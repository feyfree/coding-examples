package com.feyfree.design.factory.abstractfactory;

/**
 * 具体类
 *
 * @author leilei
 */
public class SummerTextField implements ITextField {
    /**
     * 抽象方法
     */
    @Override
    public void display() {
        System.out.println("This is a summer text field!");
    }
}
