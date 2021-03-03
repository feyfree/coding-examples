package com.feyfree.leetcode.p0041;

/**
 * 置换算法
 * <p>
 * 如果数组中包含 x 且 x∈[1,N]，那么恢复后，数组的第 x−1 个元素为 x
 *
 * @author leilei
 */
public class OtherSolution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 假设 k = nums[i] ; 进行交换  k 应该出现在 nums[k - 1] 上面
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}