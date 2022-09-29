package com.feyfree.leetcode.p0447;


import java.util.*;

/**
 * https://leetcode.cn/problems/number-of-boomerangs/
 *
 * @author leilei
 */
class Solution {

    static class Pair {
        int[] a;
        int[] b;

        public Pair(int[] a, int[] b) {
            this.a = a;
            this.b = b;
        }

        public int[] getA() {
            return a;
        }

        public void setA(int[] a) {
            this.a = a;
        }

        public int[] getB() {
            return b;
        }

        public void setB(int[] b) {
            this.b = b;
        }

        public static Pair of(int[] a, int[] b) {
            return new Pair(a, b);
        }
    }


    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, List<Pair>> container = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0])
                            + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                    List<Pair> list = container.getOrDefault(distance, new ArrayList<>());
                    if (list.isEmpty()) {
                        list.add(Pair.of(points[i], points[j]));
                        container.put(distance, list);
                    } else {
                        list.add(Pair.of(points[i], points[j]));
                    }
                }
            }
        }
        int result = 0;
        for (Map.Entry<Integer, List<Pair>> item : container.entrySet()) {
            List<Pair> pairs = item.getValue();
            int[] lastPoint = null;
            int accumulator = 0;
            if (pairs.size() > 1) {
                for (Pair pair : pairs) {
                    if (lastPoint == null || Arrays.equals(pair.getA(), lastPoint)) {
                        accumulator += 1;
                    } else {
                        result += accumulator * (accumulator - 1);
                        accumulator = 1;
                    }
                    lastPoint = pair.getA();
                }
                if (accumulator > 0) {
                    result += accumulator * (accumulator - 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // [[0,0],[1,0],[-1,0],[0,1],[0,-1]]
        Solution solution = new Solution();
        int[][] data = new int[][]{
                new int[]{0, 0},
                new int[]{1, 0},
                new int[]{-1, 0},
                new int[]{0, 1},
                new int[]{0, -1}
        };
        int i = solution.numberOfBoomerangs(data);
        System.out.println(i);
    }
}


