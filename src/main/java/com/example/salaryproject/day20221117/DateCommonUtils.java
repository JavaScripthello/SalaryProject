package com.example.salaryproject.day20221117;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @program: SalaryProject
 * @description: 时间日期
 * @author: kangwei
 * @create: 2022-11-17 21:57
 **/
@Slf4j
public class DateCommonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateCommonUtils.class);

    private static final String[] DATE_PATTERN = new String[]{"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss"};


    /**
     * 日期比较方式一
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static int compareToDate(Date startDate, Date endDate) {
//        boolean after = LocalDate.now().isAfter(LocalDate.now().plusDays(-2));
//        startDate.before(endDate);
//        startDate.after(endDate);
        return startDate.compareTo(endDate); //0-开始日期等于结束日期 -1 开始日期小于结束日期 1开始日期大于结束日期
    }


    /**
     * 解析日期
     *
     * @param dateStr
     */
    public static Date checkDate(String dateStr) {
        try {
            Date date = DateUtils.parseDate(dateStr, DATE_PATTERN);
            return date;
        } catch (ParseException e) {
            LOGGER.error("日期解析异常" + e);
        }
        return null;

    }

    /**
     * 计算两个时间字符串
     *
     * @param start
     * @param end
     */
    public static void days(String start, String end) {
        try {
            if (StringUtils.isBlank(start) || StringUtils.isBlank(end)) {
                return;
            }

            LocalDate startDate = LocalDate.parse(start, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            LocalDate endDate = LocalDate.parse(end, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            long days = startDate.until(endDate, ChronoUnit.DAYS);
            long years = startDate.until(endDate, ChronoUnit.YEARS);
            long months = startDate.until(endDate, ChronoUnit.MONTHS);

            log.info("两个日期相差天数==>{}", days);
            log.info("两个日期相差年==>{}", years);
            log.info("两个日期相差月==>{}", months);
        } catch (Exception e) {
            log.error("日期解析异常", e);
        }
    }
}
