package com.feyfree.leetcode.p0229;

import java.util.ArrayList;
import java.util.List;

/**
 * 摩尔投票算法
 *
 * @author leilei
 */
public class MooreSolution {

    public List<Integer> majorityElement(int[] nums) {
        int n1 = 0;
        int c1 = 0;
        int n2 = 1;
        int c2 = 0;
        for (int num : nums) {
            if (num == n1) {
                ++c1;
            } else if (num == n2) {
                ++c2;
            } else if (c1 == 0) {
                n1 = num;
                c1 = 1;
            } else if (c2 == 0) {
                n2 = num;
                c2 = 1;
            } else {
                --c1;
                --c2;
            }
        }
        c1 = c2 = 0;
        for (int num : nums) {
            if (num == n1) {
                ++c1;
            } else if (num == n2) {
                ++c2;
            }
        }
        int c = nums.length / 3;
        List<Integer> ans = new ArrayList<>();
        if (c1 > c) {
            ans.add(n1);
        }
        if (c2 > c) {
            ans.add(n2);
        }
        return ans;
    }
}
