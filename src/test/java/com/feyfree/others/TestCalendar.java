package com.feyfree.others;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestCalendar {

    @Test
    public void testCalendar() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_YEAR, 30);
        System.out.println(instance.getTime());
    }

    @Test
    public void testPair() {
        for (int i = 0; i < 24; i++) {
            System.out.println(getPerHourStartAndEndTime(i, new Date()));
        }
    }

    private Pair<String, String> getPerHourStartAndEndTime(int i, Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.HOUR_OF_DAY, i);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        Date startTime = cal.getTime();
        cal.set(Calendar.HOUR_OF_DAY, i);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 59);
        Date endTime = cal.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return Pair.of(format.format(startTime), format.format(endTime));
    }


}
