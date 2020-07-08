package com.feyfree.leetcode.p15;

import org.junit.Test;

import java.util.List;

public class TestSolution {

    @Test
    public void testSolution() {
        Solution solution = new Solution();
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

    @Test
    public void testAdvancedSolution() {
        AdvancedSolution solution = new AdvancedSolution();
        int[] nums = {0, 0, 0, 0};
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);

    }
}
