package com.kh.app.util.db;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateFormat {
	public static String formattedDate(String originalDate) throws Exception {
		String formattedDate = originalDate;
		if(originalDate != null) {
			formattedDate = LocalDate.parse(originalDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).format(DateTimeFormatter.ofPattern("yy.MM.dd"));
		}
		return formattedDate;
	}
}
