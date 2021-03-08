package com.feyfree.jvm.dispatch;

import java.util.Random;

/**
 * 方法静态分派演示
 *
 * @author leilei
 */
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Man guy) {
        System.out.println("Hello, gentle man");
    }

    public void sayHello(Woman guy) {
        System.out.println("Hello, lady");
    }

    public void sayHello(Human guy) {
        System.out.println("Hello, guy");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch dispatch = new StaticDispatch();
        dispatch.sayHello(man);
        dispatch.sayHello(woman);

        // 前面的Human 表示的是静态类型  后面的是实际类型
        Human human = (new Random().nextBoolean() ? new Man() : new Woman());

        // 静态类型变化
        // Casting 'human' to 'Man' may produce 'ClassCastException'
        dispatch.sayHello((Man) human);
        dispatch.sayHello((Woman) human);
    }
}
