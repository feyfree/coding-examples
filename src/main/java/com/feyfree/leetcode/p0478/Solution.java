package com.feyfree.leetcode.p0478;


import java.util.Arrays;
import java.util.Random;

/**
 * 圆内生成随机点
 *
 * @author leilei
 */
class Solution {


    private double xCenter;

    private double yCenter;

    private double radius;

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.xCenter = x_center;
        this.yCenter = y_center;
    }

    /**
     * 利用角向量
     * 随机半径
     *
     * @return
     */
    public double[] randPoint() {
        double r = Math.sqrt(new Random().nextDouble() * radius * radius);
        double angle = new Random().nextDouble() * Math.PI * 2;
        return new double[]{
                r * Math.cos(angle) + xCenter,
                r * Math.sin(angle) + yCenter
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution(10, 0, 0);
        solution.randPoint();
        System.out.println(Arrays.toString(solution.randPoint()));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */