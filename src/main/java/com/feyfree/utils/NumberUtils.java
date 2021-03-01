package com.feyfree.utils;

import java.util.ArrayList;
import java.util.List;

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
        List<String> a = new ArrayList<>();
        a.add("1");
        a.add("2");
        List<String> b = new ArrayList<>();
        b.add("1");
        b.add("3");
        b.retainAll(a);
        System.out.println(b);
    }
}
