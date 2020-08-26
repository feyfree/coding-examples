package com.feyfree.leetcode.p45;

/**
 * 高效解法
 * <p>
 * jump as far as possible
 *
 * @author leilei
 */
public class GreedySolution {
    public int jump(int[] nums) {
        // 需要跳跃的次数
        int steps = 0;
        //
        int near = 0;
        int far = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > near) {
                ++steps;
                near = far;
            }
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
