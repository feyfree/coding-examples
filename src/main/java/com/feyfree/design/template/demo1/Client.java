package com.feyfree.design.template.demo1;

/**
 * 测试
 *
 * @author leilei
 */
public class Client {
    public static void main(String[] args) {
        CurrentAccount currentAccount = new CurrentAccount();
        currentAccount.handle("test", "test");


        SavingAccount savingAccount = new SavingAccount();
        savingAccount.handle("test", "test");
    }
}
