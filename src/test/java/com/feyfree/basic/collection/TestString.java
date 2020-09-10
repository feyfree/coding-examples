package com.feyfree.basic.collection;


import org.junit.Test;

public class TestString {

    @Test
    public void testStringBuilder() {
        new StringBuilder();
        String s = new String();
    }

    @Test
    public void testCharacter() {
        int[] indices = new int[Character.MAX_VALUE];
        int m = 'a';
        char a = Character.MAX_VALUE - 1;
        System.out.println(m);
        System.out.println(a);
    }
}
