package com.feyfree.leetcode.p0443;

/**
 * https://leetcode.cn/problems/string-compression/
 *
 * @author leilei
 */
class Solution {
    public int compress(char[] cs) {
        int n = cs.length;
        int i = 0, j = 0;
        while (i < n) {
            int idx = i;
            while (idx < n && cs[idx] == cs[i]) {
                idx++;
            }
            int cnt = idx - i;
            cs[j++] = cs[i];
            if (cnt > 1) {
                int start = j, end = start;
                while (cnt != 0) {
                    cs[end++] = (char) ((cnt % 10) + '0');
                    cnt /= 10;
                }
                reverse(cs, start, end - 1);
                j = end;
            }
            i = idx;
        }
        return j;
    }

    private void reverse(char[] cs, int start, int end) {
        while (start < end) {
            char t = cs[start];
            cs[start] = cs[end];
            cs[end] = t;
            start++;
            end--;
        }
    }
}