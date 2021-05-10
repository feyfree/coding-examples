package com.feyfree.leetcode.p0128;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 *
 * @author leilei
 */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int ans = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                continue;
            }
            Integer left = map.get(num - 1);
            Integer right = map.get(num + 1);
            left = left != null ? left : 0;
            right = right != null ? right : 0;
            int t = left + right + 1;
            map.put(num, t);
            map.put(num - left, t);
            map.put(num + right, t);
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
