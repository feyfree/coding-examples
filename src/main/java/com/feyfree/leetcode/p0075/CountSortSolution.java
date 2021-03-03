package com.feyfree.leetcode.p0075;

/**
 * 计数排序
 *
 * @author leilei
 */
public class CountSortSolution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i : nums) {
            count[i]++;
        }
        int begin = 0;
        for (int j = 0; j < 3; j++) {
            while (count[j]-- > 0) {
                nums[begin] = j;
                begin++;
            }
        }
    }
}
