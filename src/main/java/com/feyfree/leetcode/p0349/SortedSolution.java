package com.feyfree.leetcode.p0349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 数据排序后进行筛选
 *
 * @author leilei
 */
public class SortedSolution {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> container = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] > nums2[idx2]) {
                idx2++;
            } else if (nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                container.add(nums1[idx1]);
                idx1++;
                idx2++;
            }
        }
        List<Integer> distinct = container.stream().distinct().collect(Collectors.toList());
        int[] result = new int[distinct.size()];
        for (int i = 0; i < distinct.size(); i++) {
            result[i] = distinct.get(i);
        }
        return result;
    }
}
