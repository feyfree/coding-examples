package com.feyfree.leetcode.p0395;

import java.util.Arrays;

/**
 * 滑动窗口解法
 * https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/xiang-jie-mei-ju-shuang-zhi-zhen-jie-fa-50ri1/
 *
 * @author leilei
 */
public class SlideWindowSolution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] count = new int[26];
        for (int p = 1; p <= 26; p++) {
            Arrays.fill(count, 0);
            int j = 0, distinct = 0, satisfied = 0;
            // distinct 代表 [j, i] 区间所有的字符种类数量；satisfied 代表满足「出现次数不少于 k」的字符种类数量
            for (int i = 0; i < n; i++) {
                int u = chars[i] - 'a';
                count[u]++;
                // 如果添加到 count 之后为 1，说明字符总数 +1
                if (count[u] == 1) {
                    distinct++;
                }
                // 如果添加到 count 之后等于 k，说明该字符从不达标变为达标，达标数量 + 1
                if (count[u] == k) {
                    satisfied++;
                }
                // 当区间所包含的字符种类数量 distinct 超过了当前限定的数量 p，那么我们要删除掉一些字母，即「左指针」右移
                while (distinct > p) {
                    int t = chars[j++] - 'a';
                    count[t]--;
                    // 如果添加到 count 之后为 0，说明字符总数-1
                    if (count[t] == 0) {
                        distinct--;
                    }
                    // 如果添加到 count 之后等于 k - 1，说明该字符从达标变为不达标，达标数量 - 1
                    if (count[t] == k - 1) {
                        satisfied--;
                    }
                }
                // 当所有字符都符合要求，更新答案
                if (distinct == satisfied) {
                    ans = Math.max(ans, i - j + 1);
                }
            }
        }
        return ans;
    }

}
