package com.feyfree.design.strategy.demo1;

/**
 * 抽象折扣类
 *
 * @author leilei
 */
public interface IDiscount {

    /**
     * 计算折后价格
     *
     * @param price 价格
     * @return 折后价格
     */
    double calculate(double price);
}
