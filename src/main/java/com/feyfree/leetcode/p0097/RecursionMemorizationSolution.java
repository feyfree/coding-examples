package com.feyfree.leetcode.p0097;

/**
 * 递归和记忆化搜索
 *
 * @author leilei
 */
public class RecursionMemorizationSolution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] result = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                result[i][j] = -1;
            }
        }
        return dp(s1, l1, s2, l2, s3, s3.length(), result);
    }

    private boolean dp(String s1, int l1, String s2, int l2, String s3, int l3, int[][] result) {
        if (l1 + l2 != l3) {
            return false;
        }
        if (l1 == 0 && l2 == 0) {
            return true;
        }
        if (result[l1][l2] != -1) {
            return result[l1][l2] == 1;
        }
        if (l1 > 0 && s3.charAt(l3 - 1) == s1.charAt(l1 - 1) && dp(s1, l1 - 1, s2, l2, s3, l3 - 1, result)
                || l2 > 0 && s3.charAt(l3 - 1) == s2.charAt(l2 - 1) && dp(s1, l1, s2, l2 - 1, s3, l3 - 1, result)) {
            result[l1][l2] = 1;
        } else {
            result[l1][l2] = 0;
        }
        return result[l1][l2] == 1;
    }

    public static void main(String[] args) {
        RecursionMemorizationSolution solution = new RecursionMemorizationSolution();
        System.out.println(solution.isInterleave("", "b", "b"));

    }
}
