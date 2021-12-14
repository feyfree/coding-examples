package com.feyfree.leetcode.p0395;

/**
 * 优化DFS
 *
 * @author leilei
 */
public class AdvancedDfsSolution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int left, int right, int k) {
        int[] cnt = new int[26];
        for (int i = left; i <= right; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return right - left + 1;
        }

        int result = 0;
        // ------------*-----------*--------------*
        // 类似上面的结构 dfs 只能搜索split 中间的内容
        while (left <= right) {
            // left 相当于一个cursor
            while (left <= right && s.charAt(left) == split) {
                left++;
            }
            if (left > right) {
                break;
            }
            int start = left;
            while (left <= right && s.charAt(left) != split) {
                left++;
            }
            result = Math.max(result, dfs(s, start, left - 1, k));
        }
        return result;
    }
}
