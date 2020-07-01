package com.feyfree.crackingcoding.chapter9.s1;

import org.junit.Test;

public class TestSolution {

    @Test
    public void test() {
        Solution1 solution1 = new Solution1();
        String[] testCases = {
                "abcd",
                "abca"};
        for (String testCase : testCases) {
            System.out.println("testCases:  " + testCase);
            System.out.println("result:" + solution1.noRepeatedWords(testCase));
        }
    }
}
