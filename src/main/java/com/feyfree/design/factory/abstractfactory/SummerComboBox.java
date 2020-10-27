package com.feyfree.design.factory.abstractfactory;

/**
 * 具体类
 *
 * @author leilei
 */
public class SummerComboBox implements IComboBox {
    /**
     * 抽象
     */
    @Override
    public void display() {
        System.out.println("This is a summer combo box!");
    }
}
