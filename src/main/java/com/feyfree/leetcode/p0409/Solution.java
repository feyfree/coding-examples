package com.feyfree.leetcode.p0409;

/**
 * 409. 最长回文串
 * 偶数个  或者 偶数个 + 1
 *
 * @author leilei
 */
class Solution {
    public int longestPalindrome(String s) {
        int[] alphas = new int[256];
        for (int i = 0; i < s.length(); i++) {
            alphas[s.charAt(i) - 'A']++;
        }
        int result = 0;
        int odd = 0;
        for (int alpha : alphas) {
            if (alpha > 0) {
                if ((alpha & 1) == 0) {
                    result += alpha;
                } else {
                    result += (alpha - 1);
                    odd = 1;
                }
            }
        }
        return result + odd;
    }

    public static void main(String[] args) {
        System.out.println('A' - 'a' + 'a');
    }
}