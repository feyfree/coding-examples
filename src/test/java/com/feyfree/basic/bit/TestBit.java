package com.feyfree.basic.bit;

import org.junit.Test;

public class TestBit {

    @Test
    public void test() {
        printResult(-1);
        printResult(3);
        printResult(-3);
        printResult(-2);
    }

    private void printResult(int j) {
        System.out.println("***************" + j + "***************");
        System.out.println(Integer.toBinaryString(j));
        // 算术右移 看符号位的
        System.out.println((j >> 1) + ":" + Integer.toBinaryString(j >> 1));
        // 逻辑右移 不看符号位(默认是0补齐)
        System.out.println((j >>> 1) + ":" + Integer.toBinaryString(j >>> 1));
    }
}
