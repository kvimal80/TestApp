FROM quay.io/quarkus/centos-quarkus-maven:20.2-java8 AS build
#RUN mkdir -p /tmp/ssl-libs
RUN mkdir -p /tmp/
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
##COPY cacerts /tmp/ssl-libs
#COPY cacerts /opt/graalvm/jre/lib/security
USER root
RUN chown -R quarkus /usr/src/app
USER quarkus
RUN curl -L https://github.optum.com/ClaimsProcessing/cpe-certs/raw/master/myTrustStore -o /tmp/myTrustStore
RUN curl -L https://github.optum.com/ClaimsProcessing/cpe-certs/raw/master/cpe.jks -o /tmp/cpe.jks
#RUN curl -L https://github.optum.com/ClaimsProcessing/cpe-certs/raw/master/myTrustStore -o /tmp/ssl-libs/myTrustStore
#RUN curl -L https://github.optum.com/ClaimsProcessing/cpe-certs/raw/master/cpe.jks -o /tmp/ssl-libs/cpe.jks
RUN mvn -f /usr/src/app/pom.xml -Pnative clean package -Dquarkus.profile={CPEENV}

## Stage 2 : create the docker final image
FROM registry.access.redhat.com/ubi8/ubi-minimal
####### Splunk setup - Start #######
ENV TZ='America/New_York'
USER root
# install necessary tools
RUN microdnf update && microdnf install -y wget tar gzip
ENV SPLUNK_HOME /home/helper/splunk/splunkforwarder
ENV HELPER_HOME /home/helper
#Create Splunk Home
RUN mkdir -p $SPLUNK_HOME
RUN mkdir -p $HELPER_HOME/_scripts && \
    	    mkdir -p $HELPER_HOME/resources
#Add input files to resources
ADD ./common-pipeline/_splunk/*.conf /home/helper/resources/
#Add the start up wrapper script
COPY ./common-pipeline/_scripts/*.sh /home/helper/_scripts/
#Set permissions
RUN  chmod -R 777 /home/helper
#Download Splunk Forwarder
WORKDIR /home/helper/splunk/
RUN curl -L -o splunkforwarder-6.5.2-67571ef4b87d-Linux-x86_64.tgz https://repo1.uhc.com/artifactory/generic-local/monitoring/splunk/splunkforwarder-6.5.2-67571ef4b87d-Linux-x86_64.tgz
RUN /bin/tar zxvf splunkforwarder-6.5.2-67571ef4b87d-Linux-x86_64.tgz
RUN rm -f splunkforwarder-6.5.2-67571ef4b87d-Linux-x86_64.tgz
#Download splunk configurations
WORKDIR $HELPER_HOME/resources
RUN curl -L -o optum_npe_ose_outputs.tgz https://repo1.uhc.com/artifactory/generic-local/monitoring/splunk/optum_npe_ose_outputs.tgz && \
    curl -L -o optum_phi_ose_outputs.tgz https://repo1.uhc.com/artifactory/generic-local/monitoring/splunk/optum_phi_ose_outputs.tgz    
RUN  chmod -R 777 /home/helper/splunk
####### Splunk setup - End #######
WORKDIR /work/
COPY --from=build /usr/src/app/target/*-runner /work/application
#COPY --from=build /tmp/ssl-libs /work
RUN chmod 775 /work
RUN chmod 777 /tmp
EXPOSE 8080
ENTRYPOINT ["/home/helper/_scripts/entryPoint_quarkus.sh"]
