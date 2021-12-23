package com.feyfree.leetcode.p0373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
 *
 * @author leilei
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 大堆  维护K个选项
        PriorityQueue<List<Integer>> maxHeap = new PriorityQueue<>(((o1, o2) -> (o2.get(0) + o2.get(1)) - (o1.get(0) + o1.get(1))));
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            for (int j = 0; j < Math.min(nums2.length, k); j++) {
                if (maxHeap.size() < k) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums1[i]);
                    list.add(nums2[j]);
                    maxHeap.offer(list);
                } else {
                    int top = maxHeap.peek().get(0) + maxHeap.peek().get(1);
                    if (top > nums1[i] + nums2[j]) {
                        maxHeap.poll();
                        List<Integer> list = new ArrayList<>();
                        list.add(nums1[i]);
                        list.add(nums2[j]);
                        maxHeap.offer(list);
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            result.add(maxHeap.poll());
        }
        return result;
    }
}