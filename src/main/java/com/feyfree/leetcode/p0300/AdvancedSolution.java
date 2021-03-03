package com.feyfree.leetcode.p0300;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 * 时间复杂度 到n log(n)
 *
 * @author feyfree
 */
public class AdvancedSolution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            // 写个二分查找 找到一个比 i 大的最小的那个数
            int replaceIndex = lowerBound(result, num);
            if (replaceIndex >= result.size()) {
                result.add(num);
            } else {
                result.set(replaceIndex, num);
            }
        }
        return result.size();
    }

    private int lowerBound(List<Integer> data, int bound) {
        int low = 0;
        int high = data.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (data.get(mid) < bound) {
                low = mid + 1;
                if (low < data.size() && data.get(low) > bound) {
                    return mid + 1;
                }
            } else if (data.get(mid) == bound) {
                return mid;
            } else {
                high = mid - 1;
                if (high < 0 || data.get(high) < bound) {
                    return high + 1;
                }
            }
        }
        return data.size();
    }

    public static void main(String[] args) {
        AdvancedSolution data = new AdvancedSolution();
        List<Integer> test = new ArrayList<>();
        test.add(10);
        test.add(11);
        test.add(12);
        System.out.println(data.lowerBound(test, 1));
    }
}
