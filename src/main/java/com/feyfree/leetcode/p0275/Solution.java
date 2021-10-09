package com.feyfree.leetcode.p0275;

public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0;
        int r = n;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (citations[n - m - 1] <= m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
