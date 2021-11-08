package com.feyfree.leetcode.p0318;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 318. 最大单词长度乘积
 * https://leetcode-cn.com/problems/maximum-product-of-word-lengths/
 *
 * @author feyfree
 */
public class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        System.out.println(Arrays.toString(words));
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String later = words[n - 1 - i];
                String pre = words[n - 1 - j];
                if (!hasSame(later, pre)) {
                    result = Math.max(result, later.length() * pre.length());
                }
            }
        }
        return result;
    }


    private boolean hasSame(String a, String b) {
        int[] count = new int[26];
        for (int i = 0; i < a.length(); i++) {
            count[a.charAt(i) - 'a']++;
        }
        for (int i = 0; i < b.length(); i++) {
            if (count[b.charAt(i) - 'a'] > 0) {
                return true;
            }
        }
        return false;
    }
}
