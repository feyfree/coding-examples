package com.feyfree.leetcode.p0149;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 149. 直线上最多的点数
 * https://leetcode-cn.com/problems/max-points-on-a-line/
 *
 * @author leilei
 */
public class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            Map<String, Integer> count = new HashMap<>();
            int samePoints = 1;
            int maxPoints = 0;
            for (int j = i + 1; j < n; ++j) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                if (p1[0] == p2[0] && p1[1] == p2[1]) {
                    samePoints++;
                } else {
                    int[] slope = getSlope(p1, p2);
                    String key = Arrays.toString(slope);
                    Integer val = count.getOrDefault(key, 0);
                    maxPoints = Math.max(maxPoints, val + 1);
                    count.put(key, val + 1);
                }
            }
            ans = Math.max(ans, samePoints + maxPoints);
        }
        return ans;
    }

    private int[] getSlope(int[] p1, int[] p2) {
        int dx = p2[0] - p1[0];
        int dy = p2[1] - p1[1];

        // horizontal line
        if (dy == 0) {
            return new int[]{p1[1], 0};
        }
        // vertical line
        if (dx == 0) {
            return new int[]{0, p1[0]};
        }

        int d = gcd(dx, dy);
        return new int[]{dy / d, dx / d};
    }

    private int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}
