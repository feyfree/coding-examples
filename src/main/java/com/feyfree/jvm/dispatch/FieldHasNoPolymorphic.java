package com.feyfree.jvm.dispatch;

/**
 * 字段不参与多态
 * <p>
 * Son 类创建的时候首先隐式调用了Father 的构造函数
 * 而Father 构造函数中对showMeTheMoney()的调用是一次虚方法调用
 * 实际执行的版本是Son::showMeTheMoney()方法， 所以输出的是 "I am son"
 * 而这时候虽然父类的money 字段已经被初始化成为2了, 但是Son::showMeTheMoney()方法中访问的却是子类的字段
 * 这时候结果自然还是 0
 * <p>
 * result=
 * ---------------------------
 * I am son, i have $0
 * I am son, i have $4
 * This guy has $2
 * ---------------------------
 *
 * @author leilei
 */
public class FieldHasNoPolymorphic {
    static class Father {
        public int money = 1;

        public Father() {
            money = 2;
            showMeTheMoney();
        }

        public void showMeTheMoney() {
            System.out.println("I am father, i have $" + money);
        }
    }

    static class Son extends Father {
        public int money = 3;

        public Son() {
            money = 4;
            showMeTheMoney();
        }

        @Override
        public void showMeTheMoney() {
            System.out.println("I am son, i have $" + money);
        }
    }

    public static void main(String[] args) {
        Father guy = new Son();
        System.out.println("This guy has $" + guy.money);
    }
}

