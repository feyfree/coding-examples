package com.feyfree.leetcode.p15;

import org.junit.Test;

/**
 * 测试二分查找
 */
public class TestBinarySearch {

    @Test
    public void testBinarySearch() {
        Solution solution = new Solution();
        int[] nums = {-4, -3, -2, -1, 0, 0, 11, 12, 17, 19, 21};
        System.out.println(solution.findValue(nums, 2, 13));
    }

}
