package com.feyfree.basic.time;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    @Test
    public void testTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(new Date());
        System.out.println(time);
        System.out.println(time.equals("20200902"));
        System.out.println(offlineStatus("20200908"));
    }

    /**
     *  判断活动是否结束
     */
    private boolean offlineStatus(String offlineTime) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date offlineDate = dateFormat.parse(offlineTime);
        return offlineDate.before(new Date());
    }
}
