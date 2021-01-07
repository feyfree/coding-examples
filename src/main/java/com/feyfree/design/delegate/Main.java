package com.feyfree.design.delegate;

/**
 * 代理模式注重的是过程， 委派模式注重的是结果
 * <p>
 * 策略模式注重可扩展性(外部扩展性)， 委派模式注重内部的灵活性和可调用性
 * <p>
 * 委派模式的核心就是分发， 调度和派遣， 委派模式是静态代理和策略模式的一种特殊组合
 */
public class Main {
    public static void main(String[] args) {
        new Boss().command("driving", new Leader());
    }
}
