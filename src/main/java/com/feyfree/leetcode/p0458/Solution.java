package com.feyfree.leetcode.p0458;

/**
 * https://leetcode.cn/problems/poor-pigs/
 * 动态规划
 * 用 f(i,j) 表示 i 只小猪测试 j 轮最多可以在多少桶液体中确定有毒的是哪一桶。在确定最大测试轮数为
 * iterations 的情况下，需要计算使得 f(i,iterations)≥buckets 成立的最小的 i
 * <p>
 * 几头小猪构建几维度空间  (https://leetcode.cn/problems/poor-pigs/solutions/15770/hua-jie-suan-fa-458-ke-lian-de-xiao-zhu-by-guanpen/)
 *
 * @author leilei
 */
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie;
        // 浮点数的精度存在问题
        return (int) Math.ceil(Math.log(buckets) / Math.log(times + 1) - 1e-5);
    }
}
