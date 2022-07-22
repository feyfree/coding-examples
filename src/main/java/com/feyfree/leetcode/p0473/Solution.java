package com.feyfree.leetcode.p0473;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.cn/problems/matchsticks-to-square/
 * dfs 解法
 *
 * @author leilei
 */
public class Solution {


    private boolean[] used;

    private final int edges = 4;

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < edges) {
            return false;
        }
        int total = Arrays.stream(matchsticks).sum();
        if (total % edges != 0) {
            return false;
        }
        // 边的长度
        int target = total / 4;
        for (int matchstick : matchsticks) {
            if (matchstick > target) {
                return false;
            }
        }
        this.used = new boolean[matchsticks.length];

        // 排序, 从后往前搜索
        Arrays.sort(matchsticks);
        return false;


    }


    private boolean dfs(int target, int left, int[] sticks, List<Integer> current, int index) {
        if (calculateSum(current, sticks) == target && left - 1 == 0) {

        }
        return false;


    }


    private int calculateSum(List<Integer> current, int[] data) {
        int sum = 0;
        for (Integer index : current) {
            sum += data[index];
        }
        return sum;
    }

    public static void main(String[] args) {
    }


}
