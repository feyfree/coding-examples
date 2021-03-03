package com.feyfree.leetcode.p0031;

/**
 * next-permutation
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * 解题思路
 * sample array
 * 1  2  7  6  5  4  2
 * <p>
 * 1. 找到从后往前数第一个  后一个比前一个大的 比如这个是 ‘2’   第二个
 * <p>
 * 2. 找到从后往前数 第一个  大于 ‘2’的数 是 4
 *
 * 3. 交换
 * 1 4 7 6 5 2 2
 *
 * 4. 反转
 * 1 4 2 2 5 6 7
 *
 * @author leilei
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            --i;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                --j;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    /**
     * 交换数组中的两个value
     *
     * @param nums 操作数组
     * @param i    index i
     * @param j    index j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 7, 6, 5, 4, 2};
        solution.nextPermutation(nums);
    }
}
