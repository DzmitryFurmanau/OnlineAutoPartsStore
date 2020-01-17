package com.onlinestore.app.converter;

import org.dozer.DozerConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The type Local date time converter.
 */
public class LocalDateTimeConverter extends DozerConverter<LocalDateTime, String> {


    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * Instantiates a new Local date time converter.
     */
    public LocalDateTimeConverter() {
        super(LocalDateTime.class, String.class);
    }

    @Override
    public String convertTo(LocalDateTime localDateTime, String date) {
        return localDateTime.format(formatter);
    }

    @Override
    public LocalDateTime convertFrom(String date, LocalDateTime localDateTime) {
        return LocalDateTime.parse(date, formatter);
    }
}
