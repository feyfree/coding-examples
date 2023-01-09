package com.feyfree.leetcode.p0475;

import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/heaters/
 * 每个点, 找到最近的加热器, 找到每个点最大的半径
 * <p>
 * TreeSet 解法
 * nlog(n)
 *
 * @author leilei
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        TreeSet<Integer> heaterSet = new TreeSet<>();
        for (int one : heaters) {
            heaterSet.add(one);
        }
        int result = Integer.MIN_VALUE;
        for (int house : houses) {
            Integer ceiling = heaterSet.ceiling(house);
            Integer floor = heaterSet.floor(house);
            int distanceA = Integer.MAX_VALUE;
            int distanceB = Integer.MAX_VALUE;
            if (floor != null) {
                distanceA = house - floor;
            }
            if (ceiling != null) {
                distanceB = ceiling - house;
            }
            int radius = Math.min(distanceA, distanceB);
            result = Math.max(result, radius);
        }
        return result;
    }
}