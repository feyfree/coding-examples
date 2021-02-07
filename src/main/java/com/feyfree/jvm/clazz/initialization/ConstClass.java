package com.feyfree.jvm.clazz.initialization;

/**
 *
 * @author leilei
 */
public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLO_WORLD = "Hello, World!";
}
