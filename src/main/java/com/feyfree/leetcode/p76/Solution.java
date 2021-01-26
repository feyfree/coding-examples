package com.feyfree.leetcode.p76;

/**
 * 最小覆盖子串
 * 尝试用 O(n) 解决此问题
 *
 * @author leilei
 */
class Solution {
    public String minWindow(String s, String t) {
        int[] cnt = new int[128];
        for (char c : t.toCharArray()) {
            cnt[c]++;
        }
        // 起点
        int from = 0;
        int total = t.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < s.length(); i++) {
            // 将 i 所在的字符对应的 数量自减 1
            if (cnt[s.charAt(i)]-- > 0) {
                // total 也需要自减
                total--;
            }
            // 当total 减少到 0 的时候
            while (total == 0) {
                // 更新 区间 min 的值
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                // 向前推进 j  这个大于 0 的条件实际上是 指的是 cnt
                if (++cnt[s.charAt(j++)] > 0) {
                    total++;
                }
            }
        }
        return (min == Integer.MAX_VALUE) ? "" : s.substring(from, from + min);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        solution.minWindow(s, t);
    }
}
