package pl.pbarczewski.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public interface DateFormatter {

	public static LocalDate formatDate(String date) throws Exception {
		LocalDate parsedDate = null;
		try {
			if(!date.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
				parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("d-MM-yyyy"));
			} else {
			parsedDate = LocalDate.parse(date);
			}
		} catch (DateTimeParseException e) {
			throw new Exception("Date is incorrect");
		}
		return parsedDate;
	}
}
