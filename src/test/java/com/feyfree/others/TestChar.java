package com.feyfree.others;

import org.junit.Test;

public class TestChar {

    @Test
    public void testCharAt() {
        String s = "abcd";
        int[] array = new int[256];
        array[s.charAt(1)] = 1;
        System.out.println(s.charAt(1));
        System.out.println(array[s.charAt(1)]);
        System.out.println(array['b']);
    }
}
