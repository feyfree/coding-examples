package com.feyfree.develop;


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.util.Calendar.DAY_OF_MONTH;

/**
 * @Description:
 * @Company: YJ
 * @Date: 2019/5/7 16:36
 * @Author: lanyl
 */
public class TimeUtils {

    public static String getBeforeTimeByNow(Long millisecond) {
        long resultTime = System.currentTimeMillis() - millisecond;
        Date dateTime = new Date(resultTime);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(dateTime);
    }

    public static String getTodayStr() {
        Date dateTime = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
        return dateFormat.format(dateTime);
    }

    public static Date getDateByStr(String dateStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        return dateFormat.parse(dateStr, pos);
    }

    public static Date getDayStartTime(String dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        ParsePosition pos = new ParsePosition(0);
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTimeInMillis(dateFormat.parse(dateTime, pos).getTime());
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    public static Date getDayEndTime(String dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        ParsePosition pos = new ParsePosition(0);
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTimeInMillis(dateFormat.parse(dateTime, pos).getTime());
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    public static Date getMonthStartTime(String dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        ParsePosition pos = new ParsePosition(0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateFormat.parse(dateTime, pos).getTime());
        calendar.add(Calendar.YEAR, 0);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static Date getMonthEndTime(String dateTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        ParsePosition pos = new ParsePosition(0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateFormat.parse(dateTime, pos).getTime());
        calendar.add(Calendar.MONTH, 0);
        calendar.add(Calendar.YEAR, 0);
        calendar.set(DAY_OF_MONTH, calendar.getActualMaximum(DAY_OF_MONTH));// 获取当前月最后一天
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    public static String getDate(long date) {
        Date dateTime = new Date(date);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(dateTime);
    }

    public static String getMonthByDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
        return dateFormat.format(date);
    }

    public static List<Integer> getListMonthByDate(Date beginDate, Date endDate) {
        List<Integer> monthList = new ArrayList<>();
        Calendar beginCalendar = Calendar.getInstance();
        beginCalendar.setTime(beginDate);
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.setTime(endDate);
        int beginYear = beginCalendar.get(Calendar.YEAR);
        int beginMonth = beginCalendar.get(Calendar.MONTH);
        int endYear = endCalendar.get(Calendar.YEAR);
        int endMonth = endCalendar.get(Calendar.MONTH);
        int m = beginMonth;
        for (int y = beginYear; y <= endYear; y++) {
            while (true) {
                Calendar monthCalendar = Calendar.getInstance();
                monthCalendar.set(Calendar.YEAR, y);
                monthCalendar.set(Calendar.MONTH, m);
                monthList.add(Integer.valueOf(getMonthByDate(monthCalendar.getTime())));
                if (m == endMonth) {
                    break;
                }
                if (m == Calendar.DECEMBER) {
                    m = Calendar.JANUARY;
                } else {
                    m++;
                }
            }
        }
        return monthList;
    }

    /**
     * 获取前三个月的月份列表
     *
     * @return 前三个月的月份列表
     */
    public static String[] getPreviousThreeMonthByDate() {
        String[] months = new String[3];
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        months[0] = sd.format(calendar.getTime());
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        months[1] = sd.format(calendar.getTime());
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
        months[2] = sd.format(calendar.getTime());
        return months;
    }

    /**
     * 获取前一个月的月份
     */
    public static String getPreviousMonthByDate(Date timePoint) {
        System.out.println(timePoint);
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
        Calendar instance = Calendar.getInstance();
        instance.setTime(timePoint);
        instance.set(Calendar.MONTH, instance.get(Calendar.MONTH) - 1);
        System.out.println(instance.getTime());
        return sd.format(instance.getTime());
    }

    /**
     * @param
     * @return
     * @author leilei
     * @date 2019/12/16 15:39
     * @description 获取当月第一天
     **/
    public static Date getMonthStartTime(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }


    /**
     * @param
     * @return
     * @author leilei
     * @date 2019/12/16 15:42
     * @description 获取每月的最后一天
     **/
    public static Date getMonthEndTime(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(DAY_OF_MONTH, ca.getActualMaximum(DAY_OF_MONTH));
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        ca.set(Calendar.MILLISECOND, 999);
        return ca.getTime();
    }

    public static String getDayByDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(date);
    }

    // 获取当天的开始时间
    public static Date getCurBeginTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }


    /**
     * 获取当前时间到第二天凌晨的秒数
     *
     * @return
     */
    public static Long getSecondsNextEarlyMorning() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
    }

    /**
     * 当前时间加几天
     *
     * @param day
     * @return
     */
    public static Date plusDate(Integer day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, day);
        return calendar.getTime();
    }

    /**
     * @param
     * @return
     * @author leilei
     * @date 2019/11/28 18:57
     * @description 获取
     **/
    public static boolean isMonday(Date param) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(param);
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY;
    }

    /**
     * @param
     * @return
     * @author leilei
     * @date 2019/11/28 19:08
     * @description 获取每周周一开始时间和每周结束时间
     **/
    public static Date getWeekMondayTime(Date param) {
        Calendar calendarMonday = Calendar.getInstance();
        calendarMonday.setTime(param);
        calendarMonday.setFirstDayOfWeek(Calendar.MONDAY);
        calendarMonday.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return getCurrentDayStart(calendarMonday.getTime());
    }

    /**
     * @param
     * @return
     * @author leilei
     * @date 2019/11/28 19:28
     * @description 获取每周结束的时间
     **/
    public static Date getWeekEndTime(Date param) {
        Date weekMondayTime = getWeekMondayTime(param);
        Calendar instance = Calendar.getInstance();
        instance.setTime(weekMondayTime);
        instance.add(Calendar.DATE, 6);
        instance.set(Calendar.HOUR_OF_DAY, 23);
        instance.set(Calendar.MINUTE, 59);
        instance.set(Calendar.SECOND, 59);
        instance.set(Calendar.MILLISECOND, 999);
        return instance.getTime();
    }

    /**
     * @param currentTime 给定的时间
     * @author leilei
     * @date 2019/10/23 8:54
     * @desc 根据时间戳获取当天的零点时间
     **/
    public static Date getCurrentDayStart(Date currentTime) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(currentTime);
        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        instance.set(Calendar.SECOND, 0);
        instance.set(Calendar.MILLISECOND, 0);
        return instance.getTime();
    }


    public static Date getLastDayOfMonth(Date date) {
        Calendar cDay1 = Calendar.getInstance();
        cDay1.setTime(date);
        final int lastDay = cDay1.getActualMaximum(DAY_OF_MONTH);
        Date lastDate = cDay1.getTime();
        lastDate.setDate(lastDay);
        return lastDate;
    }


    /**
     * 是否是同月
     *
     * @param a 时间
     * @param b 时间
     * @return true 表示同月 false 表示不是
     */
    public static boolean sameMonth(Date a, Date b) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        return format.format(a).equals(format.format(b));
    }
}

