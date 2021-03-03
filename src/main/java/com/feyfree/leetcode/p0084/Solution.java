package com.feyfree.leetcode.p0084;


import java.util.Stack;

/**
 * p84 柱状图最大的矩形
 * 和接雨水不同
 * <p>
 * Use a monotonic stack to maintain the higher bars’s indices in ascending order.
 * When encounter a lower bar, pop the tallest bar and use it as the bottleneck to compute the area.
 *
 * 用一个单调的栈区维持一个更高的柱 的索引（高度递增）
 * 如果遇到了一个更低的柱子， 将最高的柱子弹出，
 * <p>
 * Time complexity: O(n)
 * Space complexity: O(n)
 * <p>
 * reference:
 * https://zxi.mytechroad.com/blog/stack/leetcode-84-largest-rectangle-in-histogram/
 *
 * @author leilei
 */
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int i = 0;
        // 单调栈的思想
        while (i <= n) {
            int height = i == n ? 0 : heights[i];
            if (stack.isEmpty() || height >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                // 实际相当于end 确定，不断地换 start 来计算最大值
                int h = heights[stack.peek()];
                stack.pop();
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                result = Math.max(result, h * w);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(heights));
    }
}