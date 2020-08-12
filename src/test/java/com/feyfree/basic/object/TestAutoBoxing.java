package com.feyfree.basic.object;

import org.junit.Test;

public class TestAutoBoxing {

    @Test
    public void testAutoBoxing() {
//        Integer a = null;
//        int b = a;
    }

    @Test
    public void testNull() {
        Integer.valueOf(0);
    }

    @Test
    public void testChar() {
        char a = '1';
        char c = (char) (8 + a);
        System.out.println(c);
    }
}
