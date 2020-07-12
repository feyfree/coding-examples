package com.feyfree.basic.string;

import org.junit.Test;

public class TestStringBuilder {

    @Test
    public void testStringBuilderIntern() {
        String s = new StringBuilder("计算机").append("科学").toString();
        System.out.println(s.intern().equals(s));

        String s2 = new StringBuilder("ja").append("va").toString();
        System.out.println(s2.intern().equals(s2));
    }
}
