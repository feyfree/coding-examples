package com.feyfree.work.case003;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

    private static String getCompareDate(Date d, int days, String pattern) {
        Date date = DateUtils.addDays(d, -days);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

    public static void main(String[] args) throws ParseException {
        Date date = DateUtils.parseDate("20220118", "yyyyMMdd");
        String oldDate = getCompareDate(date, 2, "yyyyMMdd");
        System.out.println(oldDate);
    }

}
