package com.example.teamapt.util;

import com.example.teamapt.enums.DateTimeEnum;
import com.google.common.base.Strings;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @author iModupsy
 * @created 03/03/2022
 */
public class DateTimeUtil {

	public static LocalDateTime getDateTime() {
		return LocalDateTime.now(getTimeZone());
	}

	public static LocalDate getDate() {
		return LocalDate.now(getTimeZone());
	}

	public static String getDateTime(LocalDateTime dt) {
		if (dt == null)
			return null;
		return dt.format(getDateTimeFormatter());
	}

	public static String getDate(LocalDate d) {
		if (d == null) {
			return null;
		}
		return d.format(getDateFormatter());
	}

	public static LocalDateTime getDateTime(String dt) {
		if (Strings.isNullOrEmpty(dt)) {
			return null;
		}
		return LocalDateTime.parse(dt,
				DateTimeFormatter.ofPattern(DateTimeEnum.DATE_TIME_PATTERN));
	}

	public static LocalDate getDate(String d) {
		if (Strings.isNullOrEmpty(d)) {
			return null;
		}
		return LocalDate.parse(d, DateTimeFormatter.ofPattern(DateTimeEnum.DATE_PATTERN));
	}

	public static DateTimeFormatter getDateTimeFormatter() {
		return DateTimeFormatter.ofPattern(DateTimeEnum.DATE_TIME_PATTERN);
	}

	public static LocalDateTime getDatabaseDateTimeFormat(String dateTime) {
		return LocalDateTime.parse(dateTime,
				DateTimeFormatter.ofPattern(DateTimeEnum.DATABASE_DATE_TIME_PATTERN));
	}

	public static DateTimeFormatter getDateFormatter() {
		return DateTimeFormatter.ofPattern(DateTimeEnum.DATE_PATTERN);
	}

	public static ZoneOffset getTimeZone() {
		return ZoneOffset.of("+1");
	}

	public static LocalDateTime getLocalDateTime(String theDate) {
		if (Strings.isNullOrEmpty(theDate)) {
			return null;
		}
		return getDatabaseDateTimeFormat(theDate);

	}

}
