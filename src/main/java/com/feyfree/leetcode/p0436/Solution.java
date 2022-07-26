package com.feyfree.leetcode.p0436;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/find-right-interval/
 *
 * @author leilei
 */
class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] result = new int[intervals.length];
        Arrays.fill(result, -1);
        TreeSet<int[]> tree = new TreeSet<>(Comparator.comparingInt(o -> o[1]));
        for (int i = 0; i < intervals.length; i++) {
            tree.add(new int[]{i, intervals[i][0]});
        }
        for (int i = 0; i < intervals.length; i++) {
            int[] target = intervals[i];
            target[1] = target[1] - 1;
            int[] data = tree.higher(target);
            if (data != null) {
                if (data[0] != i) {
                    result[i] = data[0];
                } else {
                    int[] ceiling = tree.ceiling(target);
                    if (ceiling != null && ceiling[0] != i) {
                        result[i] = data[0];
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] data = new int[][]{
                new int[]{3, 4}, new int[]{2, 3}, new int[]{1, 2}
        };
        Solution solution = new Solution();
        solution.findRightInterval(data);
    }
}