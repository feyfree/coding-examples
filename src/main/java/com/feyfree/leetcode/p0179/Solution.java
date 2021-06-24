package com.feyfree.leetcode.p0179;


import java.util.Arrays;

/**
 * 179. 最大数
 * https://leetcode-cn.com/problems/largest-number/
 *
 * @author leilei
 */
public class Solution {
    public String largestNumber(int[] nums) {
        nums = Arrays.stream(nums).
                boxed().
                sorted((a, b) -> {
                    char[] parseA
                            = String.valueOf(a).toCharArray();
                    char[] parseB = String.valueOf(b).toCharArray();
                    for (int i = 0; i < parseA.length && i < parseB.length; i++) {
                        if (parseA[i] > parseB[i]) {
                            return -1;
                        }
                        if (parseA[i] < parseB[i]) {
                            return 1;
                        }
                    }
                    return Integer.compare(parseA.length, parseB.length);
                }).mapToInt(i -> i).
                toArray();
        StringBuilder result = new StringBuilder();
        for (int a : nums) {
            result.append(a);
        }
        return result.toString();
    }


    public static int compareInt(int a, int b) {
        char[] parseA
                = String.valueOf(a).toCharArray();
        char[] parseB = String.valueOf(b).toCharArray();
        for (int i = 0; i < parseA.length && i < parseB.length; i++) {
            if (parseA[i] > parseB[i]) {
                return -1;
            }
            if (parseA[i] < parseB[i]) {
                return 1;
            }
        }
        return Integer.compare(parseA.length, parseB.length);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(nums));
    }
}
