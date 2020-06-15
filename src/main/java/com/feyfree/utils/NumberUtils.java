package com.feyfree.utils;

/**
 * 数字判断
 *
 * @author leilei
 */
public class NumberUtils {

    /**
     * 是否是 2 的整数次 幂
     *
     * @param val 输入
     * @return true 是 false 不是
     */
    public static boolean isPowerOfTwo(int val) {
        return (val & -val) == val;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(9));
        System.out.println(Integer.toBinaryString(-9));
        System.out.println(Integer.toBinaryString(9 & -9));
        System.out.println(isPowerOfTwo(9));
    }
}
