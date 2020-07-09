package com.feyfree.leetcode.p17;

import org.junit.Test;

import java.util.List;

public class TestSolution {

    @Test
    public void testDFS() {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);

    }

    @Test
    public void testBFS() {
        Solution2 solution2 = new Solution2();
        List<String> strings = solution2.letterCombinations("23");
        System.out.println(strings);
    }
}
