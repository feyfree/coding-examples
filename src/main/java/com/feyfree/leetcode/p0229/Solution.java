package com.feyfree.leetcode.p0229;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/majority-element-ii/
 * 229. 求众数 II
 *
 * @author leilei
 */
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i : map.keySet()) {
            if (map.get(i) > nums.length / 3) {
                res.add(i);
            }
        }
        return res;
    }
}
