package com.feyfree.design.strategy.demo1;

/**
 * 学生折扣
 *
 * @author leilei
 */
public class StudentDiscount implements IDiscount {
    /**
     * 计算折后价格
     *
     * @param price 价格
     * @return 折后价格
     */
    @Override
    public double calculate(double price) {
        double realPrice = price * 0.8;
        System.out.println("学生价格" + realPrice);
        return realPrice;
    }
}
