package com.feyfree.leetcode.p0391;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * 计算corner
 *
 * @author leilei
 */
public class AdvancedSolution {

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Coordinate that = (Coordinate) o;
            return x == that.x && y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public boolean isRectangleCover(int[][] rectangles) {
        Set<Coordinate> corners = new HashSet<>();
        int area = 0;
        for (int[] rec : rectangles) {
            Coordinate c1 = new Coordinate(rec[0], rec[1]);
            Coordinate c2 = new Coordinate(rec[2], rec[1]);
            Coordinate c3 = new Coordinate(rec[2], rec[3]);
            Coordinate c4 = new Coordinate(rec[0], rec[3]);
            process(corners, c1);
            process(corners, c2);
            process(corners, c3);
            process(corners, c4);
            area += (c3.getX() - c1.getX()) * (c3.getY() - c1.getY());
        }
        if (corners.size() != 4) {
            return false;
        }
        int left = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        int up = Integer.MIN_VALUE;
        for (Coordinate cor : corners) {
            left = Math.min(left, cor.getX());
            down = Math.min(down, cor.getY());
            right = Math.max(right, cor.getX());
            up = Math.max(up, cor.getY());
        }
        return area == (right - left) * (up - down);
    }

    private void process(Set<Coordinate> corners, Coordinate c1) {
        boolean flag = corners.add(c1);
        if (!flag) {
            corners.remove(c1);
        }
    }
}
