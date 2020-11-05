package com.feyfree.design.template.demo1;

/**
 * 储蓄账户
 *
 * @author leilei
 */
public class SavingAccount extends Account {
    /**
     * 计算利息
     */
    @Override
    public void calculateInterest() {
        System.out.println("储蓄账户年利率2%");
    }
}
