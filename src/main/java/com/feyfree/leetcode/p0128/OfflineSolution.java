package com.feyfree.leetcode.p0128;

import java.util.*;

/**
 * 离线做法
 *
 * @author leilei
 */
public class OfflineSolution {
    public int longestConsecutive(int[] nums) {
        // set 实际上是一个ordered set  时间复杂度实际上是不满足要求的
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums).forEach(set::add);
        int ans = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int l = 0;
                while (set.contains(num++)) {
                    ++l;
                }
                ans = Math.max(ans, l);
            }
        }
        return ans;
    }
}
