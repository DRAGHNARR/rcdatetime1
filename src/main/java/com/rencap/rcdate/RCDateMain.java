package com.rencap.rcdate;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;


public class RCDateMain {
    public String now(String toPattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(toPattern)).toString();
    }

    public String format(String in, String fromPattern, String toPattern) {
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(in, DateTimeFormatter.ofPattern(fromPattern));
        }
        catch (java.time.format.DateTimeParseException e0) {
            try {
                date = LocalDate.parse(in, DateTimeFormatter.ofPattern(fromPattern)).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date = LocalTime.parse(in, DateTimeFormatter.ofPattern(fromPattern)).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        return date.format(DateTimeFormatter.ofPattern(toPattern));
    }

    public String format(String in, String toPattern) {
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(in);
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date = LocalDate.parse(in).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date = LocalTime.parse(in).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        return date.format(DateTimeFormatter.ofPattern(toPattern));
    }

    public String plus(String in, String fromPattern, long amountToAdd, String unit) {
        String result;
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(in, DateTimeFormatter.ofPattern(fromPattern));
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date = LocalDate.parse(in, DateTimeFormatter.ofPattern(fromPattern)).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date = LocalTime.parse(in, DateTimeFormatter.ofPattern(fromPattern)).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        switch (unit) {
            case "years":
                result = date.plus(amountToAdd, ChronoUnit.YEARS).format(DateTimeFormatter.ofPattern(fromPattern)).toString();
                break;
            case "months":
                result = date.plus(amountToAdd, ChronoUnit.MONTHS).format(DateTimeFormatter.ofPattern(fromPattern)).toString();
                break;
            case "days":
                result = date.plus(amountToAdd, ChronoUnit.DAYS).format(DateTimeFormatter.ofPattern(fromPattern)).toString();
                break;
            case "hours":
                result = date.plus(amountToAdd, ChronoUnit.HOURS).format(DateTimeFormatter.ofPattern(fromPattern)).toString();
                break;
            case "minutes":
                result = date.plus(amountToAdd, ChronoUnit.MINUTES).format(DateTimeFormatter.ofPattern(fromPattern)).toString();
                break;
            default:
                result = date.format(DateTimeFormatter.ofPattern(fromPattern)).toString();
        }
        return result;
    }

    public String plus(String in, long amountToAdd, String unit) {
        String result;
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(in);
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date = LocalDate.parse(in).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date = LocalTime.parse(in).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        switch (unit) {
            case "years": result = date.plus(amountToAdd, ChronoUnit.YEARS).toString();
                break;
            case "months": result = date.plus(amountToAdd, ChronoUnit.MONTHS).toString();
                break;
            case "days": result = date.plus(amountToAdd, ChronoUnit.DAYS).toString();
                break;
            case "hours": result = date.plus(amountToAdd, ChronoUnit.HOURS).toString();
                break;
            case "minutes": result = date.plus(amountToAdd, ChronoUnit.MINUTES).toString();
                break;
            default: result = date.toString();
        }
        return result;
    }

    public String plusDays(String in, String fromPattern, long days) {
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(in, DateTimeFormatter.ofPattern(fromPattern));
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date = LocalDate.parse(in, DateTimeFormatter.ofPattern(fromPattern)).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date = LocalTime.parse(in, DateTimeFormatter.ofPattern(fromPattern)).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        return date.plusDays(days).format(DateTimeFormatter.ofPattern(fromPattern)).toString();
    }

    public String plusDays(String in, long days) {
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(in);
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date = LocalDate.parse(in).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date = LocalTime.parse(in).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        return date.plusDays(days).toString();
    }

    public String plusHours(String in, String fromPattern, long hours) {
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(in, DateTimeFormatter.ofPattern(fromPattern));
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date = LocalDate.parse(in, DateTimeFormatter.ofPattern(fromPattern)).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date = LocalTime.parse(in, DateTimeFormatter.ofPattern(fromPattern)).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        return date.plusHours(hours).format(DateTimeFormatter.ofPattern(fromPattern)).toString();
    }

    public String plusHours(String in, long hours) {
        LocalDateTime date;
        try {
            date = LocalDateTime.parse(in);
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date = LocalDate.parse(in).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date = LocalTime.parse(in).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        return date.plusHours(hours).toString();
    }

    public boolean compare(String in1, String fromPattern1, String operator, String in2, String fromPattern2) {
        boolean result;
        LocalDateTime date1;
        LocalDateTime date2;
        try {
            date1 = LocalDateTime.parse(in1, DateTimeFormatter.ofPattern(fromPattern1));
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date1 = LocalDate.parse(in1, DateTimeFormatter.ofPattern(fromPattern1)).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date1 = LocalTime.parse(in1, DateTimeFormatter.ofPattern(fromPattern1)).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        try {
            date2 = LocalDateTime.parse(in2, DateTimeFormatter.ofPattern(fromPattern2));
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date2 = LocalDate.parse(in2, DateTimeFormatter.ofPattern(fromPattern2)).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date2 = LocalTime.parse(in2, DateTimeFormatter.ofPattern(fromPattern2)).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        switch (operator) {
            case "eq": result = date1.isEqual(date2);
                break;
            case "ge": result = (date1.isEqual(date2) || date1.isAfter(date2));
                break;
            case "le": result = (date1.isEqual(date2) || date1.isBefore(date2));
                break;
            case "gt": result = date1.isAfter(date2);
                break;
            case "lt": result = date1.isBefore(date2);
                break;
            default: result = false;
        }
        return result;
    }

    public boolean compare(String in1, String operator, String in2) {
        boolean result;
        LocalDateTime date1;
        LocalDateTime date2;
        try {
            date1 = LocalDateTime.parse(in1);
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date1 = LocalDate.parse(in1).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date1 = LocalTime.parse(in1).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        try {
            date2 = LocalDateTime.parse(in2);
        }
        catch (java.time.format.DateTimeParseException e) {
            try {
                date2 = LocalDate.parse(in2).atStartOfDay();
            }
            catch (java.time.format.DateTimeParseException e1) {
                date2 = LocalTime.parse(in2).atDate(LocalDate.of(1970, 1, 1));
            }
        }
        switch (operator) {
            case "eq": result = date1.isEqual(date2);
                break;
            case "ge": result = (date1.isEqual(date2) || date1.isAfter(date2));
                break;
            case "le": result = (date1.isEqual(date2) || date1.isBefore(date2));
                break;
            case "gt": result = date1.isAfter(date2);
                break;
            case "lt": result = date1.isBefore(date2);
                break;
            default: result = false;
                break;
        }
        return result;
    }
}