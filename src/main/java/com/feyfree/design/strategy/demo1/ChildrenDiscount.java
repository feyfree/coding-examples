package com.feyfree.design.strategy.demo1;

/**
 * 儿童票价
 *
 * @author feyfree
 */
public class ChildrenDiscount implements IDiscount {
    /**
     * 计算折后价格
     *
     * @param price 价格
     * @return 折后价格
     */
    @Override
    public double calculate(double price) {
        double realPrice = price * 0.6;
        System.out.println("儿童价格" + realPrice);
        return realPrice;
    }
}
