package com.feyfree.leetcode.p7;

import org.junit.Test;

public class TestSolution {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int reverse = solution.reverse(-12);
        System.out.println(reverse);
    }

    @Test
    public void testPythonAndJavaAlgOperation() {
        int x = -12;
        System.out.println(x % 10);
        System.out.println(x / 10);
        System.out.println((double) x / 10);
    }
}
