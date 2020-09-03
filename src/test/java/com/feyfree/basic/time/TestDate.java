package com.feyfree.basic.time;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

    @Test
    public void testTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(new Date());
        System.out.println(time);
        System.out.println(time.equals("20200902"));
    }
}
