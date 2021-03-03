package com.feyfree.leetcode.p0239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution copied from huahua
 *
 * @author leilei
 */
public class HuahuaSolution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> indices = new LinkedList<>();

        for (int i = 0; i < nums.length; ++i) {
            // 目标是 在每个 indices 队列中 始终保持左边第一个是最大的
            while (indices.size() > 0 && nums[i] >= nums[indices.getLast()]) {
                indices.removeLast();
            }

            indices.addLast(i);
            if (i - k + 1 >= 0) {
                ans[i - k + 1] = nums[indices.getFirst()];
            }
            // 表明滑动窗口已经过去了, indices 里面保持的滑动窗口块需要更新
            if (i - k + 1 >= indices.getFirst()) {
                indices.removeFirst();
            }
        }

        return ans;
    }
}