package com.feyfree.basic.operation;

import org.junit.Test;

public class TestNumber {

    @Test
    public void autoTransform() {
        // 必须要加括号
        int data = (1 << 28) + 100;
        System.out.println(data);

        double result = (double) (1 << 28) + 100;
        System.out.println(result);
    }

    @Test
    public void test() {
        int[] numbers = new int[]{1, 1};
        System.out.println(numbers[1]-- > 0);
        System.out.println(numbers[1]);
    }

    @Test
    public void testMod() {
        System.out.println(-11 % 10);
    }

    @Test
    public void testBinary() {
        System.out.println(Integer.toBinaryString(192));
    }


}
