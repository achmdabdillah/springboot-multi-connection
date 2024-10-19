package com.template.demo.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

@Component
public class TimeUtil {
    private static final DateTimeFormatter ppdFormatterInput = new DateTimeFormatterBuilder().parseCaseInsensitive()
            .appendPattern("yyyy/MM/dd").toFormatter();
    private static final DateTimeFormatter ppdFormatterOutput = DateTimeFormatter.ofPattern("yyyyMMdd");

    private static final DateTimeFormatter expiryFormatterInput = DateTimeFormatter.ofPattern("yyyy/MM/dd'T'HH:mm:ss");
    private static final DateTimeFormatter isoFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public String getCurrentTime() {
        ZonedDateTime dateNow = ZonedDateTime.now(ZoneId.of("UTC+7"));
        return dateNow.format(isoFormatter);
    }

    // public String formatDatePpd(String date) {
    // String[] splitDate = date.split("-");
    // if (splitDate[1].length() > 3) {
    // date = splitDate[0] + "-" + splitDate[1].substring(0, 3) + "-" +
    // splitDate[3];
    // }
    // LocalDate dateInput = LocalDate.parse(date, ppdFormatterInput);
    // String output = dateInput.format(ppdFormatterOutput);
    // return output;
    // }

    public String formatDatePpd(String date) {
        LocalDate dateInput = LocalDate.parse(date, ppdFormatterInput);
        String output = dateInput.format(ppdFormatterOutput);
        return output;
    }

    public String getExpiryDate(String date) {
        LocalDateTime dateInput = LocalDateTime.parse(date.replace(" ", "T"), expiryFormatterInput);
        dateInput = dateInput.plusDays(7);
        String output = dateInput.format(isoFormatter);
        return output;
    }
}
