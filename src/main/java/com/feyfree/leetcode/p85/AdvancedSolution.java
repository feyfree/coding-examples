package com.feyfree.leetcode.p85;

import java.util.Stack;

/**
 * 第84题作为基础 85题在此基础上延伸
 *
 * @author leilei
 */
public class AdvancedSolution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int result = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < cols; j++) {
                if (chars[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            result = Math.max(result, largestRectangleArea(heights));
        }
        return result;
    }

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
}
