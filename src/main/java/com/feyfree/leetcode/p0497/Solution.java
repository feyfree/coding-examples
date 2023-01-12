package com.feyfree.leetcode.p0497;

import java.util.*;

/**
 * https://leetcode.cn/problems/random-point-in-non-overlapping-rectangles/
 * <p>
 * 优化点 -> 可以构造 prefix sum tree
 *
 * @author leilei
 */
public class Solution {


    private final int[][] containers;

    private int total;

    public Solution(int[][] rects) {
        containers = rects;
        for (int[] rectangle : rects) {
            int x0 = rectangle[0];
            int y0 = rectangle[1];
            int x1 = rectangle[2];
            int y1 = rectangle[3];
            int points = (x1 - x0 + 1) * (y1 - y0 + 1);
            total += points;
        }
    }

    public int[] pick() {
        Random random = new Random();
        int step = random.nextInt(total) + 1;
        for (int[] container : containers) {
            int[] point = getPoint(container, step);
            if (point != null) {
                return point;
            } else {
                step = step - getContainerPointNum(container[0], container[1], container[2], container[3]);
            }
        }
        return null;
    }


    /**
     * 获取点位
     *
     * @param container
     * @param offset
     * @return
     */
    private int[] getPoint(int[] container, int offset) {
        int x0 = container[0];
        int y0 = container[1];
        int x1 = container[2];
        int y1 = container[3];
        int width = x1 - x0 + 1;
        int height = y1 - y0 + 1;
        int count = height * width;
        if (offset > count) {
            return null;
        }
        int rows = (offset - 1) / width;
        int mod = (offset - 1) % width;
        return new int[]{x0 + mod, y0 + rows};
    }

    private int getContainerPointNum(int x0, int y0, int x1, int y1) {
        int width = x1 - x0 + 1;
        int height = y1 - y0 + 1;
        return height * width;
    }
}
