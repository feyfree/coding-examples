package com.feyfree.others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestHours {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
        Date parse = format.parse("2020042409");
        Calendar instance = Calendar.getInstance();
        instance.setTime(parse);
        System.out.println(instance.get(Calendar.HOUR_OF_DAY));

        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        System.out.println();

    }
}
