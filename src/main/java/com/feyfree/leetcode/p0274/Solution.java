package com.feyfree.leetcode.p0274;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/h-index/
 * 274. H 指数
 *
 * @author leilei
 */
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if (citations.length - 1 - i >= citations[i]) {
                return citations.length - 1 - i;
            }
        }
        return citations.length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.hIndex(new int[]{3, 0, 6, 1, 5});
    }
}
