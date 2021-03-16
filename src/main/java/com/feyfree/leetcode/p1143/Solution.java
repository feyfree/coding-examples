package com.feyfree.leetcode.p1143;

/**
 * 最长公共子序列
 * <p>
 * 给定两个字符串 text1 和text2，返回这两个字符串的最长公共子序列的长度。
 * <p>
 * 一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * <p>
 * 若这两个字符串没有公共子序列，则返回 0。
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符。
 * ------------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        // dp[i][j] 实际上是值  text1[i - 1] 和 text2[j -1] 的数值
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                boolean matchHere = text1.charAt(i - 1) == text2.charAt(j - 1);
                boolean matchFirst = i - 2 >= 0 && text1.charAt(i - 2) != text2.charAt(j - 1) && matchHere;
                boolean matchSecond = j - 2 >= 0 && text1.charAt(i - 1) != text2.charAt(j - 2) && matchHere;
                if (matchFirst || matchSecond) {
                    dp[i][j] += 1;
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        Solution solution = new Solution();
        solution.longestCommonSubsequence(text1, text2);
    }
}
