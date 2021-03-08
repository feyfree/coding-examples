package com.feyfree.jvm.dispatch;

import java.io.Serializable;

public class Overload {
    public static void sayHello(Object arg) {
        System.out.println("Hello object");
    }

    public static void sayHello(int arg) {
        System.out.println("Hello, int");
    }

    public static void sayHello(Character arg) {
        System.out.println("Hello, character");
    }

    public static void sayHello(char arg) {
        System.out.println("Hello, char");
    }

    public static void sayHello(char... chars) {
        System.out.println("Hello, char...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("Hello, serializable");
    }

    public static void main(String[] args) {
        sayHello('a');
    }
}
