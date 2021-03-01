package com.feyfree.develop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestProjects {

    /**
     * 获取前一个月的月份
     */
    public static String getPreviousMonthByDate(Date timePoint) {
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
        Calendar instance = Calendar.getInstance();
        instance.setTime(timePoint);
        instance.set(Calendar.MONTH, instance.get(Calendar.MONTH) - 1);
        return sd.format(instance.getTime());
    }


    public static Date getDate(String dateString) throws ParseException {
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sd.parse(dateString);
    }

    public static String dateString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }


    public static void main(String[] args) throws ParseException {
        Date endDate = getDate("2020-07-31 05:01:01");
        Date plusDate = TimeUtils.plusDate(-15);
        System.out.println("----");
        System.out.println(dateString(plusDate));
        System.out.println("----");
        int endTableIndex = Integer.parseInt(TimeUtils.getMonthByDate(endDate));
        // 获取上个月的数据
        int previousTableIndex = Integer.parseInt(TimeUtils.getPreviousMonthByDate(endDate));
        System.out.println(endTableIndex);
        System.out.println(previousTableIndex);
//        String previousMonthByDate = getPreviousMonthByDate(getDate("2021-01-01 00:00:00"));
//        System.out.println(previousMonthByDate);
    }
}
