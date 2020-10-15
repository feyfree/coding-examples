package com.feyfree.others;

import org.junit.Test;

public class TestTruncate {

    private Long truncateMoney(Long income) {
        if (income < 10 * 100) {
            return income / 100;
        }
        if (income < 10 * 1000) {
            return income / 1000 * 10;
        }
        return income / 10000 * 100;
    }

    @Test
    public void testTruncate() {
        System.out.println(truncateMoney(650L));
        System.out.println(truncateMoney(5620L));
        System.out.println(truncateMoney(56045L));
        System.out.println(truncateMoney(1345700L));
        System.out.println(truncateMoney(1600L));
        System.out.println(truncateMoney(1650L));
        System.out.println(truncateMoney(16500L));
        System.out.println(truncateMoney(160L));
    }

    @Test
    public void test() {
        System.out.println((double) (2 + 74 - 4) / 74 * 100);
        double v = (double) (2 + 74 - 4) / 74 * 100;
        Double aDouble = v;
        System.out.println(aDouble.intValue());
    }
}
