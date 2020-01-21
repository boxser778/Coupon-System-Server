package com.Spring.CouponSystem.Filter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateConverterUtil {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");

	private static LocalDate localDate;

	private static String customDate;

	public static LocalDate convertStringDate(String endDate) {
		localDate = LocalDate.parse(endDate, formatter);
		return localDate;
	}

	public static String DateStringFormat(LocalDate date) {
		customDate = date.format(formatter);
		return customDate;
	}

	public static LocalDate convertDateLocal(Date date) {
		customDate = date.toString();
		localDate = LocalDate.parse(customDate);
		return localDate;
	}

}