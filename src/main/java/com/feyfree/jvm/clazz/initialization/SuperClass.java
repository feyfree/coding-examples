package com.feyfree.jvm.clazz.initialization;

public class SuperClass {
    static {
        System.out.println("Super Class init!");
    }

    public static int value = 123;
}


