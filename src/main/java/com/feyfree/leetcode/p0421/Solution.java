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
        Map.Entry<Integer, List<Integer>> lowestEntry = map.firstEntry();
        Map.Entry<Integer, List<Integer>> highestEntry = map.lastEntry();
        int result = Integer.MIN_VALUE;
        if (lowestEntry.getKey().equals(highestEntry.getKey())) {
            // 内部 异或
            List<Integer> data = lowestEntry.getValue();
            for (int i = 0; i < data.size(); i++) {
                for (int j = i + 1; j < data.size(); j++) {
                    int cal = data.get(i) ^ data.get(j);
                    result = Math.max(result, cal);
                }

            }
        } else {

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8});
        System.out.println(result);
        System.out.println(25 ^ 3);
        System.out.println(25 ^ 5);
    }

}
