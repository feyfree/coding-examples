package com.feyfree.leetcode.p0287;

/**
 * 二分搜索
 * <p>
 * 时间复杂相对较高
 *
 * @author leilei
 */
public class BinarySearch {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
