package com.rixar.payments.common.utils;
import com.rixar.payments.common.exceptions.RixarRuntimeException;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class GoodDateTimeUtil {

    private GoodDateTimeUtil() {

    }

    public static String statisticMonth(Date date) {
        return new SimpleDateFormat("MMM").format(date);
    }

    public static String statisticYear(Date date) {
        return new SimpleDateFormat("yyyy").format(date);
    }

    public static Date getStartOfDay() {
        LocalDate startOfDay = LocalDate.now();
        return Date.from(startOfDay.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getEndOfDay() {
        LocalDate today = LocalDate.now();
        LocalDateTime endOfToday = LocalDateTime.of(today, LocalTime.of(23, 59, 59));
        return Date.from(endOfToday.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getStartOfWeek() {
        LocalDate today = LocalDate.now();
        LocalDate startOfTheWeek = today.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
        return Date.from(startOfTheWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getEndOfWeek() {
        LocalDate today = LocalDate.now();
        LocalDate endOfTheWeek = today.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        Date date = Date.from(endOfTheWeek.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return toEndOfDay(date);
    }

    public static Date getStartOfMonth() {
        LocalDate startOfMonth = LocalDate.now().withDayOfMonth(1);
        return Date.from(startOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public static Date getEndOfMonth() {
        LocalDate currentDate = LocalDate.now();
        LocalDateTime endOfMonth = LocalDateTime.of(currentDate.withDayOfMonth(currentDate.lengthOfMonth()),
                LocalTime.of(23, 59, 59));
        return Date.from(endOfMonth.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getStartOfMonthSubtractMonths(int monthsToSubtract) {
        LocalDate currentDate = LocalDate.now();
        LocalDate startOfMonth = currentDate.minusMonths(monthsToSubtract).withDayOfMonth(1);
        LocalDateTime startOfMonthDateTime = LocalDateTime.of(startOfMonth, LocalTime.MIDNIGHT);
        return Date.from(startOfMonthDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static Date getEndOfMonthSubtractMonths(int monthsToSubtract) {
        LocalDate currentDate = LocalDate.now();
        LocalDate endOfMonth = currentDate.minusMonths(monthsToSubtract).withDayOfMonth(currentDate.minusMonths(monthsToSubtract).lengthOfMonth());
        LocalDateTime endOfMonthDateTime = LocalDateTime.of(endOfMonth, LocalTime.of(23, 59, 59));
        return Date.from(endOfMonthDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }


    // Method to get the start of the year
    public static Date getStartOfYear() {
        LocalDate startOfYear = LocalDate.now().withDayOfYear(1);
        return Date.from(startOfYear.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    // Method to get the end of the year
    public static Date getEndOfYear() {
        LocalDate currentDate = LocalDate.now();
        LocalDateTime endOfYear = LocalDateTime.of(currentDate.withDayOfYear(currentDate.lengthOfYear()), LocalTime.of(23, 59, 59)); // Last second of the year
        return Date.from(endOfYear.atZone(ZoneId.systemDefault()).toInstant());
    }


    public static Date parseEndOfDay(String dateString) {
        Date date = parseDate(dateString);
        if (date == null) {
            System.out.printf("invalid date string %s", dateString);
            throw new RixarRuntimeException("invalid date string: " + dateString);
        }
        return toEndOfDay(date);
    }

    public static Date toEndOfDay(Date date) {
        Instant instant = date.toInstant();
        LocalDate currentDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDateTime endOfMonth = LocalDateTime.of(currentDate.withDayOfMonth(currentDate.getDayOfMonth()), LocalTime.of(23, 59, 59));
        return Date.from(endOfMonth.atZone(ZoneId.systemDefault()).toInstant());
    }


    public static Date parseDate(String dateString, Date defaultDate) {
        if (GoodStringUtil.isEmpty(dateString)) {
            return defaultDate;
        }
        return parseDate(dateString);
    }

    public static Date parseDateOrNull(String dateString) {
        if (GoodStringUtil.isEmpty(dateString)) {
            return null;
        }

        return parseDate(dateString);
    }

    public static Date parseDate(String dateString) {
        if (GoodStringUtil.isEmpty(dateString)) {
            System.out.print("Date string is null or empty");

            throw new RixarRuntimeException("Date string is null or empty");
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return simpleDateFormat.parse(dateString);
        } catch (Exception e) {
            System.out.printf("received invalid date for parsing %s. error: %s", dateString, e.getMessage());
            throw new IllegalStateException("Received invalid date");
        }
    }

    public static String formatCurrentTime() {
        return formatCurrentTime("yyyy-MM-dd");
    }

    public static String formatCurrentTime(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }

    public static String format(Date dateTime) {
        return format(dateTime,"yyyy-MM-dd HH:mm:ss");
    }

    public static String format(Date dateTime,String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(dateTime);
    }

    public static String getDateString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MMM yyyy");
        return simpleDateFormat.format(date);
    }

    public static String getTimeString(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return simpleDateFormat.format(date);
    }

    public static String getDateFlattened() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(new Date()).replace("-", "");
    }

    public static Instant addMonthsFromNow(int monthsToAdd) {
        return addMonths(Instant.now(), monthsToAdd);
    }

    public static Instant addMonths(Instant instant, int monthsToAdd) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        localDateTime = localDateTime.plusMonths(monthsToAdd);
        return localDateTime.toInstant(ZoneOffset.UTC);
    }

    public static long getProcessingTime(String startTimeString) {
        if (GoodStringUtil.isEmpty(startTimeString)) {
            return 0;
        }
        long startTime = Long.parseLong(startTimeString);
        return System.currentTimeMillis() - startTime;
    }

    public static long getProcessingTime(long startTime) {
        return System.currentTimeMillis() - startTime;
    }


    public static Instant addMinutes(long minutes) {
        return addMinutes(Instant.now(), minutes);
    }

    public static Instant addMinutes(Instant instant, long minutes) {
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
        localDateTime = localDateTime.plusMinutes(minutes);
        return localDateTime.toInstant(ZoneOffset.UTC);
    }

    public static String formatInstant(Instant instant) {
        return formatInstant(instant, "dd-MMM-yyyy HH:mm");
    }

    public static String formatInstant(Instant instant, String format) {
        LocalDateTime currentDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return currentDateTime.format(formatter);
    }

    public static Date toDate(Instant instant) {
        return Date.from(instant);
    }

    /**
     * Uses `dd-MM-yyyy` as a default date format
     *
     * @param dateString -
     * @return -
     */
    public static Instant parseDateInstant(String dateString) {
        return parseDateInstant(dateString, "dd-MM-yyyy");
    }

    public static Instant parseDateInstant(String dateString, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        LocalDateTime localDateTime = localDate.atTime(LocalTime.MAX);
        return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    public static boolean isPast(Date checkedDate) {
        Instant instant = checkedDate.toInstant();
        return instant.isAfter(Instant.now());
    }

    public static boolean isPast(Instant checkedInstant) {
        return checkedInstant.isAfter(Instant.now());
    }


}
