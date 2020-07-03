package com.feyfree.basic.memory;

/**
 * 内存别名
 *
 * @author leilei
 */
public class MemoryAliasing {
    public static void main(String[] args) {
        addTwoNumbers1(1, 2);
        System.out.println("==========");
        addTwoNumbers1(1, 1);
        System.out.println("==========");
        addTwoNumbers2(1, 1);
    }

    public static void addTwoNumbers1(int x, int y) {
        x += y;
        x += y;
        System.out.println(x);
    }

    public static void addTwoNumbers2(int x, int y) {
        x = x + 2 * y;
        System.out.println(x);
    }
}
