package com.feyfree.leetcode.p0421;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author leilei
 */
public class Solution {
    public int findMaximumXOR(int[] nums) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        // 长度最大的和 长度最小的进行循环
        for (int current : nums) {
            int highest = Integer.highestOneBit(current);
            List<Integer> container = map.get(highest);
            if (container == null) {
                container = new ArrayList<>();
            }
            container.add(current);
            map.put(highest, container);
        }
        Map.Entry<Integer, List<Integer>> firstEntry = map.firstEntry();
        Map.Entry<Integer, List<Integer>> lastEntry = map.lastEntry();
        int result = Integer.MIN_VALUE;
        if (firstEntry.getKey().equals(lastEntry.getKey())) {
            // 内部 异或
            List<Integer> data = firstEntry.getValue();
            for (int i = 0; i < data.size(); i++) {
                for (int j = i + 1; j < data.size(); j++) {
                    int cal = data.get(i) ^ data.get(j);
                    result = Math.max(result, cal);
                }

            }
        } else {
            List<Integer> data1 = firstEntry.getValue();
            List<Integer> data2 = lastEntry.getValue();
            for (Integer value1 : data1) {
                for (Integer value2 : data2) {
                    int cal = value1 ^ value2;
                    result = Math.max(result, cal);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> data = new HashSet<>();
        data.add(1);
        data.add(2);
        System.out.println(data.stream().sorted().collect(Collectors.toList()));
    }
}
