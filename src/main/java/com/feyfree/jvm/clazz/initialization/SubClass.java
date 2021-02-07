package com.feyfree.jvm.clazz.initialization;

public class SubClass extends SuperClass {
    static {
        System.out.println("Sub class init!");
    }
}
