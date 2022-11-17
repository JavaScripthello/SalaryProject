package com.example.salaryproject.day20221117;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * @program: SalaryProject
 * @description: 时间日期
 * @author: kangwei
 * @create: 2022-11-17 21:57
 **/
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

    public static void main(String[] args) {
        System.out.println(checkDate("2022-11-17"));
    }
}
