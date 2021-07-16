package com.feyfree.leetcode.p0045;

import java.util.Arrays;

/**
 * 贪心解法
 * <p>
 * jump as far as possible
 * <p>
 * 每次步骤尽量走最远
 *
 * @author leilei
 */
public class GreedySolution {
    public int jump(int[] nums) {
        System.out.println(Arrays.toString(nums));
        // 需要跳跃的次数
        int steps = 0;
        // near 上一个点能达到的最远的距离
        int near = 0;
        // far 表示在 点i 通过一个step 能到达的最远距离
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("访问第%s个节点, 当前可跨步数为%s%n", i, nums[i]);
            if (i > near) {
                ++steps;
                // 之前能达到的最远距离
                near = far;
            }
            // 在该点 next step 最远的距离
            far = Math.max(far, i + nums[i]);
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 2, 3};
        GreedySolution solution = new GreedySolution();
        System.out.println(solution.jump(nums));
    }
}
