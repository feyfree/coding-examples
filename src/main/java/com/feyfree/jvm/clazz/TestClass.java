package com.feyfree.jvm.clazz;

public class TestClass {

    static {
        System.out.println("Hi");
    }
    private int m;

    public int incr() {
        return m + 1;
    }
}
