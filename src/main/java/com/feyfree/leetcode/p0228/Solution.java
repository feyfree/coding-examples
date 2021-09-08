package com.feyfree.leetcode.p0228;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/summary-ranges/
 * 228. 汇总区间
 *
 * @author leilei
 */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (j + 1 < nums.length && nums[j + 1] == nums[j] + 1) {
                continue;
            }
            if (i == j) {
                list.add(nums[i] + "");
            } else {
                list.add(nums[i] + "->" + nums[j]);
            }
            i = j + 1;
        }
        return list;
    }
}
