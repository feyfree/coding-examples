package com.feyfree.leetcode.p0455;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/assign-cookies/
 * <p>
 * g 是胃口值
 * s 是手里的饼干
 *
 * @author leilei
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int find = 0;
        while (i < g.length && j < s.length) {
            int ri = g.length - 1 - i;
            int rj = s.length - 1 - j;
            if (g[ri] > s[rj]) {
                i++;
            } else {
                find++;
                i++;
                j++;
            }
        }
        return find;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1, 2, 3};
        int[] s = new int[]{1, 1};
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(g, s));
    }
}
