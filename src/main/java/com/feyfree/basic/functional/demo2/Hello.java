package com.feyfree.basic.functional.demo2;

/**
 *  Lambda 内部的this 的引用也就跟内部类对象没什么关系了。在Lambda 表达式中this的意义跟在表达式外部完全一样
 *  https://github.com/CarpenterLee/JavaLambdaInternals/blob/master/2-Lambda%20and%20Anonymous%20Classes(II).md
 */
public class Hello {
    Runnable r1 = () -> {
        System.out.println(this);
    };
    Runnable r2 = () -> {
        System.out.println(toString());
    };

    public static void main(String[] args) {
        new Hello().r1.run();
        new Hello().r2.run();
    }

    @Override
    public String toString() {
        return "Hello";
    }
}
