package com.feyfree.basic.hello;


import java.util.Arrays;

/**
 * @author leilei
 */
public class Hello {

    private void sayHellos(String... args) {
        System.out.println(Arrays.toString(args));
    }

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.sayHellos("Hello", "Hi");
        String[] words = {"Hi", "Hello"};
        hello.sayHellos(words);
    }
}
