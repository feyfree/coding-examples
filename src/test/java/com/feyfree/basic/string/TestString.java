package com.feyfree.basic.string;

import org.junit.Test;

public class TestString {

    @Test
    public void testString() {
        String a = "abcd";
    }

    @Test
    public void testRemove() {
        String s = removeNationalCodeAndEncript("+8618021508775");
        System.out.println(s);
    }

    private String removeNationalCodeAndEncript(String phone) {
        if (phone.startsWith("+")) {
            phone = phone.substring(1);
            System.out.println(phone);
        }
        if (phone.startsWith("86")) {
            phone = phone.substring(2);
            System.out.println(phone);

        }
        assert (phone.length() == 11);
        phone = phone.substring(0, 3) + "****" + phone.substring(8, 11);
        return phone;
    }

    @Test
    public void testImmutable() {
        String a = "123456";
        a.toCharArray();
    }

    @Test
    public void testStringIteration() {
        String a = "Hello, 世界";
        System.out.println(a.length());
        for (int i = 0; i < a.length(); i++) {
            System.out.println(a.charAt(i));
        }
    }
}
