package com.feyfree.leetcode.p0474;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 *
 * @author leilei
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        return 0;
    }


    private int[] calculateString(String s) {
        int[] result = new int[2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                result[0]++;
            } else {
                result[1]++;
            }
        }
        return result;
    }
}
