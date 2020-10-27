package com.feyfree.design.factory.abstractfactory;

/**
 * 具体类
 *
 * @author leilei
 */
public class SpringComboBox implements IComboBox {
    /**
     * 抽象
     */
    @Override
    public void display() {
        System.out.println("This is a spring combo box!");
    }
}
