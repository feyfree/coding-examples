package com.feyfree.leetcode.p0442;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-all-duplicates-in-an-array/
 *
 * @author leilei
 */
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int[] container = new int[100000 + 1];
        for (int current : nums) {
            container[current] += 1;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < container.length; i++) {
            if (container[i] == 2) {
                result.add(i);
            }
        }
        return result;
    }
}
