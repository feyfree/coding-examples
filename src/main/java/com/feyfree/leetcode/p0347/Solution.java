package com.feyfree.leetcode.p0347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 * 347. 前 K 个高频元素
 *
 *
 *
 * @author leilei
 */
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List[] buckets = new List[nums.length + 1];
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (int num : counts.keySet()) {
            int count = counts.get(num);
            if (buckets[count] == null) {
                buckets[count] = new ArrayList<Integer>();
            }
            buckets[count].add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = buckets.length - 1; i > 0 && ans.size() < k; --i) {
            if (buckets[i] != null) {
                ans.addAll(buckets[i]);
            }
        }
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}
