package com.feyfree.leetcode.p0219;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii/
 * 219. 存在重复元素 II
 *
 * @author leilei
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = indexMap.get(nums[i]);
            if (index != null && i - index <= k) {
                return true;
            }
            indexMap.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        int k = 3;
        Solution solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(nums, k));
    }
}
