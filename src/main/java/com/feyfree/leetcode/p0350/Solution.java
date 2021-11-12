package com.feyfree.leetcode.p0350;

import java.util.*;

/**
 * @author leilei
 */
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums1) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        List<Integer> container = new ArrayList<>();
        for (int num : nums2) {
            Integer count = counts.get(num);
            if (count != null && count > 0) {
                container.add(num);
                count--;
                counts.put(num, count);
            }
        }
        int[] result = new int[container.size()];
        for (int i = 0; i < container.size(); i++) {
            result[i] = container.get(i);
        }
        return result;
    }
}
