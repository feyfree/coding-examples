package com.feyfree.jvm.boxing;

public class BoxingTest {
    public static void main(String[] args) {
        Integer c = 3;
        Integer d = 3;
        System.out.println(c == d);
        Integer a = 1;
        Integer b = 2;
        System.out.println(c == (a + b));
        Long e = 3L;
        System.out.println(c.equals(e));
    }
}
