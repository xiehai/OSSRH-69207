package com.junyufr.iservice.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description 请zhanggongzheng添加代码注释
 * @Author zhanggongzheng
 * @Date 2020/10/14 15:03
 * @Version 1.0
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DateUtil {

    /**
     * 例如:2020-12-12
     */
    public static final String Y_M_D = "yyyy-MM-dd";
    public static final String YMD = "yyyyMMdd";
    public static final String Y_M = "yyyy-MM";
    /** 12/12 */
    public static final String MD_SLASH = "MM/dd";
    /** 2020/11/26 */
    public static final String YMD_SLASH = "yyyy/MM/dd";
    /** 20200101 */
    public static final String YYYYMMDD = "yyyyMMdd";
    /**
     * 例如:2020-12-12 10:00:00
     */
    public static final String YMD_HM = "yyyy-MM-dd HH:mm";
    public static final String YMD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String YMD_HMS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    public static final String YMDHMS_SSS = "yyyyMMddHHmmssSSS";
    public static final String YMDHMS = "yyyyMMddHHmmss";
    public static final String HMS = "HH:mm:ss";
    public static final String HM = "HH:mm";

    private static final DateTimeFormatter FORMATTER_YYYY_MM_DD_HH_MM_SS = getDateTimeFormatter(YMD_HMS);
    private static final DateTimeFormatter FORMATTER_YYYY_MM_DD_HH_MM_SS_SSS = getDateTimeFormatter(YMD_HMS_SSS);

    /**
     * 格式化日期为字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param date date
     * @return 日期字符串
     */
    public static String format(Date date) {
        return format(date, YMD_HMS);
    }

    /**
     * 格式化日期为字符串
     *
     * @param date    date
     * @param pattern 格式
     * @return 日期字符串
     */
    public static String format(Date date, String pattern) {
        if (date == null) {
            return null;
        }
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.format(getDateTimeFormatter(pattern));
    }

    /**
     * 获取当天日期 yyyyMMdd
     *
     * @return
     */
    public static String getToday() {
        return format(new Date(), YYYYMMDD);
    }

    /**
     * 获取当天日期
     *
     * @param fmtStr 格式
     * @return String
     */
    public static String getToday(String fmtStr) {
        return format(new Date(), fmtStr);
    }

    /**
     * 当前月
     */
    public static String getCurrentMonth() {
        return format(new Date(), "MM");
    }

    /**
     * 当前天
     */
    public static String getCurrentDay() {
        return format(new Date(), "dd");
    }

    /**
     * 当前小时
     */
    public static String getCurrentHour() {
        return format(new Date(), "HH");
    }

    /**
     * 获取当前时间 yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getCurrentTime() {
        return format(new Date(), YMD_HMS);
    }

    /**
     * 获取当前时间 pattern
     *
     * @return
     */
    public static String getCurrentTime(String pattern) {
        return format(new Date(), pattern);
    }

    /**
     * 获取当前时间 yyyyMMddHHmmssSSS
     *
     * @return
     */
    public static String getCurrentTime17() {
        return format(new Date(), YMDHMS_SSS);
    }

    /**
     * 获取当前时间 yyyyMMddHHmmss
     *
     * @return
     */
    public static String getCurrentTime14() {
        return format(new Date(), YMDHMS);
    }

    /**
     * 字符串转时间
     *
     * @param strDateTime yyyy-MM-dd HH:mm:ss
     * @return LocalDateTime
     */
    public static LocalDateTime strToDateTime(String strDateTime, DateTimeFormatter dateTimeFormatter) {
        return LocalDateTime.parse(strDateTime, dateTimeFormatter);
    }

    /**
     * 字符串转时间
     *
     * @param strDate 日期
     * @param pattern 格式
     * @return Date
     * @throws ParseException
     */
    public static Date strToDate(String strDate, String pattern) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.parse(strDate);
    }

    /**
     * 时间格式校验
     *
     * @param dateTimeStr 时间字符
     * @param pattern     格式 默认：yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static boolean isDatetime(String dateTimeStr, String pattern) {
        if (StringUtils.isEmpty(dateTimeStr)) {
            return false;
        }
        if (StringUtils.isEmpty(pattern)) {
            pattern = YMD_HMS;
        }
        try {
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            format.parse(dateTimeStr);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 生成 DateTimeFormatter
     *
     * @param pattern 格式字符串
     * @return DateTimeFormatter
     */
    private static DateTimeFormatter getDateTimeFormatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    /**
     * 时间格式校验
     *
     * @param dateTimeStr yyyy-MM-dd HH:mm:ss 或 yyyy-MM-dd HH:mm:ss SSS
     * @return
     */
    public static boolean isDatetime(String dateTimeStr) {
        int legalLen = 23;
        if (dateTimeStr == null || dateTimeStr.length() > legalLen) {
            return false;
        }
        try {
            strToDateTime(dateTimeStr, FORMATTER_YYYY_MM_DD_HH_MM_SS);
            return true;
        } catch (Exception e) {
            try {
                strToDateTime(dateTimeStr, FORMATTER_YYYY_MM_DD_HH_MM_SS_SSS);
                return true;
            } catch (Exception e1) {
                return false;
            }
        }
    }

    /**
     * Data to LocalDate
     *
     * @param date date
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        return localDateTime.toLocalDate();
    }

}
