package com.feyfree.basic.operation;

/**
 * 移位运算
 *
 * @author leilei
 */
public class BitMoveOperation {
    public static int algRightMoveOperation(int a, int num) {
        return a >> num;
    }

    public static int logicRightMoveOperation(int a, int num) {
        return a >>> num;
    }

    public static void main(String[] args) {
        int x = 10;
        System.out.println(Integer.toBinaryString(x));
        System.out.println(Integer.toBinaryString(algRightMoveOperation(x, 2)));
        System.out.println(Integer.toBinaryString(logicRightMoveOperation(x, 2)));
        int y = -10;
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(algRightMoveOperation(y, 2)));
        System.out.println(Integer.toBinaryString(logicRightMoveOperation(y, 2)));
        System.out.println("-------------max-value-----------------");
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("-------------min-value------------------");
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
    }
}
