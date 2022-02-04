package com.optum.cpe.reroute.api.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.LoggerFactory;

@ApplicationScoped
public class DateUtility {
	private final org.slf4j.Logger log = LoggerFactory.getLogger(DateUtility.class);
	
	DateTimeFormatter mdyFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	DateTimeFormatter ymdFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");
	DateTimeFormatter dateTimeFormatHyphenYear = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	DateTimeFormatter sdf = DateTimeFormatter.ofPattern("yyyyMMdd");
	DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH.mm.ss");
	public static String YYMMDD_HHMMSS_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    public String yymmddFormat(String fromDate, String fromFormat){
    	String toDate = null;;
        try {
        	DateTimeFormatter s = DateTimeFormatter.ofPattern(fromFormat);
        	toDate = ymdFormatter.format(s.parse(fromDate));
        }catch(DateTimeParseException exc){
        	log.error(exc.getMessage());
        }
        return toDate;
    }
	public String yymmddFormat(String fromDate){
    	
        String toDate = null;;
        try {
        	toDate = ymdFormatter.format(mdyFormatter.parse(fromDate));
        }catch(DateTimeParseException exc){
        	log.error(exc.getMessage());
        }
        return toDate;
    }

	public String yymmddHyphenFormat(String fromDate, String fromFormat){
		String toDate = null;;
		try {
			DateTimeFormatter s = DateTimeFormatter.ofPattern(fromFormat);
			toDate = dateTimeFormatHyphenYear.format(s.parse(fromDate));
		}catch(DateTimeParseException exc){
			log.error("Error formatting date");
		}
		return toDate;
	}
	
	public Timestamp getCurTimestamp() {
        Calendar calendar = Calendar.getInstance();
        Date currentDate = calendar.getTime();
        Timestamp timestamp = new Timestamp(currentDate.getTime());
        return timestamp;
    }
	
	public String mmddyyFormat(String fromDate){
    	
        String toDate = null;;
        try {
        	toDate = mdyFormatter.format(ymdFormatter.parse(fromDate));
        }catch(DateTimeParseException exc){
        	log.error(exc.getMessage());
        }
        return toDate;
    }
	
	public String curDateStr(){
		LocalDateTime localDateTime = LocalDateTime.now();
        String dateStr = mdyFormatter.format(localDateTime);
        
        return dateStr;
    }
	
	public String curDateStr(String dateFormat){
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat);
        String dateStr = dateFormatter.format(LocalDateTime.now());
        return dateStr;
    }
	
	public String tomorrowDate(){
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalDateTime nxtDateTime = localDateTime.plusDays(1);
		String dateStr = mdyFormatter.format(nxtDateTime);
		return dateStr;
	}
	
	public Date getCurrDate() {
		Calendar calendar = Calendar.getInstance();
	    Date currentDate = calendar.getTime();
	    return currentDate;
	}
	
	public String getCurDateTime() {
		return dateTimeFormat.format(LocalDateTime.now());
	}

	public String getCurDateTimeHyphen() {
		return dateTimeFormatHyphenYear.format(LocalDateTime.now());
	}
	
	public String getCurDate() {
		return sdf.format(LocalDateTime.now());
	}
	
	public String getCurDate(String format) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return formatter.format(LocalDateTime.now());
	}
	
	public String getCurTime() {
		return timeFormatter.format(LocalDateTime.now());
	}
	
	public java.sql.Date getDatefromTimestamp(String inPutTimeStampStr ) {
		
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		Date date = new Date();
		try {
			date = format.parse(inPutTimeStampStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	    return sqlDate;
	}

	public String yymmddFormatFromTimestamp(Timestamp timestamp){

		String toDate = null;
		try {
			toDate = ymdFormatter.format(timestamp.toLocalDateTime());
		}catch(DateTimeParseException exc){
			//log.error(exc.getMessage());
			exc.printStackTrace();
		}
		return toDate;
	}
	
}
