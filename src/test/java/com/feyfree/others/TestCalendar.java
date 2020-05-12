package com.feyfree.others;

import org.junit.Test;

import java.util.Calendar;

public class TestCalendar {

    @Test
    public void testCalendar() {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.DAY_OF_YEAR , 30);
        System.out.println(instance.getTime());
    }
}
