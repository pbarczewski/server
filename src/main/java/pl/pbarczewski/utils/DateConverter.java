package pl.pbarczewski.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.springframework.core.convert.converter.Converter;


public class DateConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String source) {
		LocalDate parsedDate = null;
		try {
			if(!source.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
				parsedDate = LocalDate.parse(source, DateTimeFormatter.ofPattern("d-MM-yyyy"));
			} else {
			parsedDate = LocalDate.parse(source);
			}
		} catch (DateTimeParseException e) {
			e.printStackTrace();
		}
		return parsedDate;
	}
}
