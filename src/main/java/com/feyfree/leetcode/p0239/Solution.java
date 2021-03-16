package com.feyfree.leetcode.p0239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 滑动窗口最大值
 * <p>
 * 给定一个数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 *
 * <p>
 * 进阶：
 * <p>
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return null;
        }
        Deque<Integer> windows = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k && windows.getFirst() <= i - k) {
                windows.pollFirst();
            }
            while (!windows.isEmpty() && nums[windows.getLast()] <= nums[i]) {
                windows.pollLast();
            }
            windows.addLast(i);
            if (i >= k - 1) {
                result[i - k + 1] = nums[windows.getFirst()];
            }
        }
        return result;
    }
}
