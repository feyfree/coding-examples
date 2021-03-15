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
        int[][] marked = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                marked[i][j] = Integer.MIN_VALUE;
            }
        }
        return dp(s1, l1, s2, l2, s3, s3.length(), marked);
    }

    private boolean dp(String s1, int l1, String s2, int l2, String s3, int l3, int[][] marked) {
        if (l1 + l2 != l3) {
            return false;
        }
        if (l1 == 0 && l2 == 0) {
            return true;
        }
        if (marked[l1][l2] != Integer.MIN_VALUE) {
            return marked[l1][l2] == 1;
        }
        if (l1 > 0 && s3.charAt(l3 - 1) == s1.charAt(l1 - 1) && dp(s1, l1 - 1, s2, l2, s3, l3 - 1, marked)
                || l2 > 0 && s3.charAt(l3 - 1) == s2.charAt(l2 - 1) && dp(s1, l1, s2, l2 - 1, s3, l3 - 1, marked)) {
            marked[l1][l2] = 1;
        } else {
            marked[l1][l2] = 0;
        }
        return marked[l1][l2] == 1;
    }

    public static void main(String[] args) {
        RecursionMemorizationSolution solution = new RecursionMemorizationSolution();
        System.out.println(solution.isInterleave("", "b", "b"));

    }
}
