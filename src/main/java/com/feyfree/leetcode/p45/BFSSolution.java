package com.feyfree.leetcode.p45;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 跳跃游戏 II
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * 说明:
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 *
 * @author leilei
 */
public class BFSSolution {

    private static final int INFINITY = Integer.MAX_VALUE;

    private boolean[] marked;

    private int[] distTo;

    public int jump(int[] nums) {
        marked = new boolean[nums.length];
        distTo = new int[nums.length];
        for (int v = 0; v < nums.length; v++) {
            distTo[v] = INFINITY;
        }
        bfs(nums, 0);
        return distTo[nums.length - 1];
    }

    private void bfs(int[] nums, int v) {
        Queue<Integer> queue = new LinkedList<>();
        marked[v] = true;
        distTo[v] = 0;
        queue.add(v);
        while (!queue.isEmpty()) {
            int s = queue.poll();
            int steps = nums[s];
            for (int i = s; i <= s + steps && i < nums.length; i++) {
                if (!marked[i]) {
                    distTo[i] = distTo[s] + 1;
                    marked[i] = true;
                    queue.add(i);
                }
                if (i == nums.length -1) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        BFSSolution solution = new BFSSolution();
        System.out.println(solution.jump(nums));
    }
}
