package com.feyfree.design.template.demo1;

/**
 * 抽象类
 *
 * @author feyfree
 */
public abstract class Account {

    /**
     * 通用方法
     *
     * @param username 用户名
     * @param password 密码
     * @return 是否通过
     */
    public boolean validate(String username, String password) {
        System.out.println("Input username:" + username);
        System.out.println("Input password:" + password);
        return "test".equals(username) && "test".equals(password);
    }

    public void display() {
        System.out.println("显示账户利息");
    }

    /**
     * 计算利息
     */
    public abstract void calculateInterest();

    /**
     * 模板方法
     *
     * @param account  用户名称
     * @param password 密码
     */
    public void handle(String account, String password) {
        if (!validate(account, password)) {
            System.out.println("账户名密码不存在");
            return;
        }
        calculateInterest();
        display();
    }
}
