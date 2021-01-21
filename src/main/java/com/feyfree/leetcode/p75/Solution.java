package com.feyfree.leetcode.p75;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public void sortColors(int[] nums) {
        // 手撸快排
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int partition = partition(nums, low, high);
        sort(nums, low, partition - 1);
        sort(nums, partition + 1, high);
    }

    private int partition(int[] data, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = data[low];
        while (true) {
            while (data[++i] < v) {
                if (i == high) {
                    break;
                }
            }
            while (v < data[--j]) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(data, i, j);
        }
        swap(data, low, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
