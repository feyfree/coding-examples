package com.feyfree.leetcode.p0395;

/**
 * 分治 递归
 *
 * @author leilei
 */
public class DfsSolution {
    public int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    public int dfs(String s, int left, int right, int k) {
        if (left > right) {
            return 0;
        }
        int[] cnt = new int[26];
        for (int i = left; i <= right; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = left; i <= right; i++) {
            if (cnt[s.charAt(i) - 'a'] < k) {
                return Math.max(dfs(s, i + 1, right, k), dfs(s, left, i - 1, k));
            }
        }

        return right - left + 1;
    }
}
