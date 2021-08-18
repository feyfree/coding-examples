package com.feyfree.leetcode.p0214;

/**
 * 214. 最短回文串
 * 给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。
 * <p>
 * s = 回文 + T
 * Tr + 回文 + T
 * <p>
 * 这个解法会超出内存限制
 *
 * @author leilei
 */
public class Solution {
    public String shortestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int index = longestPrefixPalindrome(s);
        System.out.println("index:" + index);
        if (index == s.length() - 1) {
            return s;
        }
        String t = s.substring(index + 1);
        char[] chars = t.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            result.append(chars[chars.length - 1 - i]);
        }
        return result + s;
    }

    /**
     * 找到一个字符串 最长的suffix palindrome
     *
     * @param s 输入
     * @return 终点索引
     */
    private int longestPrefixPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        int index = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && i == 0 && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    index = j;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.shortestPalindrome("q"));
    }
}
