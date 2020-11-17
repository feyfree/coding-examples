package com.feyfree.basic.time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    private static final long TWO_DAYS = 3600 * 1000 * 24 * 2;

    @Test
    public void testTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(new Date());
        System.out.println(time);
        System.out.println(time.equals("20200902"));
        System.out.println(offlineStatus("20200908"));
    }

    /**
     * 判断活动是否结束
     */
    private boolean offlineStatus(String offlineTime) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date offlineDate = dateFormat.parse(offlineTime);
        return offlineDate.before(new Date());
    }

    @Test
    public void testTimeMs() throws InterruptedException {
        Date time = new Date();
        long result = time.getTime() + TWO_DAYS - System.currentTimeMillis();
        System.out.println(result);
        double a = 1.6777216E7;
        System.out.println((long) a);

    }


}
