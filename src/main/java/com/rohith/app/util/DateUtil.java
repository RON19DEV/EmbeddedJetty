package com.rohith.app.util;

import java.time.LocalDate;

public class DateUtil {

	
	public static LocalDate convertSQLDateToLocalDate(java.sql.Date date){
		
		if(null!=date){
			
			return date.toLocalDate();
		}
		
		return null;
	}
	
}
