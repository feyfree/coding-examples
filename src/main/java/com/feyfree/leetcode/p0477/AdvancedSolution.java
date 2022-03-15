package com.feyfree.leetcode.p0477;

/**
 * 每一位所贡献的汉明距离
 * 如果 在 k 位上面 有 c 个 1 , (n - c) 个 0, 则在该位置产生的汉明距离就是  c * (n - c)
 *
 * @author leilei
 */
public class AdvancedSolution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < 30; ++i) {
            int c = 0;
            for (int val : nums) {
                c += (val >> i) & 1;
            }
            ans += c * (n - c);
        }
        return ans;
    }
}
