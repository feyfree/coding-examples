package com.feyfree.leetcode.p84;


import java.util.Stack;

/**
 * p84 柱状图最大的矩形
 * 和接雨水不同
 * <p>
 * Use a monotonic stack to maintain the higher bars’s indices in ascending order.
 * When encounter a lower bar, pop the tallest bar and use it as the bottleneck to compute the area.
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * reference:
 * https://zxi.mytechroad.com/blog/stack/leetcode-84-largest-rectangle-in-histogram/
 *
 * @author leilei
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // dp[start][end]
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int i = 0;
        while (i <= n) {
            int height = i == n ? 0 : heights[i];
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int h = heights[stack.peek()];
                stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, h * w);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {0, 9};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(heights));
    }
}