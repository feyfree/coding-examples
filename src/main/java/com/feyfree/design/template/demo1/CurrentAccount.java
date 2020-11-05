package com.feyfree.design.template.demo1;

/**
 * 活期账户
 *
 * @author leilei
 */
public class CurrentAccount extends Account {
    /**
     * 计算利息
     */
    @Override
    public void calculateInterest() {
        System.out.println("年利息在1%");
    }
}
