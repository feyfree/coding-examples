package com.feyfree.design.factory.abstractfactory;

/**
 * 具体类
 *
 * @author feyfree
 */
public class SpringButton implements IButton {
    /**
     * 方法
     */
    @Override
    public void display() {
        System.out.println("This is a spring button!");
    }
}
