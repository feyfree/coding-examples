package com.feyfree.leetcode.p0457;

/**
 * https://leetcode.cn/problems/circular-array-loop/
 * 环形数组是否存在循环
 *
 * @author leilei
 */
public class Solution {
    public boolean circularArrayLoop(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        // 从 0 开始访问， 访问到的添加到visited 当中
        for (int i = 0; i < nums.length; i++) {
            // i 相当于是 start
            if (visited[i]) {
                continue;
            }
            int j = i + nums[i];
            while (true) {
                if (j < 0) {
                    j = j % nums.length + nums.length;
                } else {
                    j = j % nums.length;
                }
                if (j == i) {
                    return true;
                }
                if (!visited[j]) {
                    visited[j] = true;
                    j = j + nums[j];
                } else {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(-5 % 3);
    }


}
