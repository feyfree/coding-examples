package com.feyfree.basic.bit;

import org.junit.Test;

public class TestBit {

    @Test
    public void test() {
        int i = -1;
        System.out.println(Integer.toBinaryString(i));
        // 算术右移
        System.out.println((i >> 1) + ":" + Integer.toBinaryString(i >> 1));
        // 逻辑右移
        System.out.println((i >>> 1) + ":" + Integer.toBinaryString(i >>> 1));

        int j = 3;
        System.out.println(Integer.toBinaryString(j));
        // 算术右移
        System.out.println((j >> 1) + ":" + Integer.toBinaryString(j >> 1));
        // 逻辑右移
        System.out.println((j >> 1) + ":" + Integer.toBinaryString(j >>> 1));
    }
}
