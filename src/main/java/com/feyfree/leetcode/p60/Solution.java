package com.feyfree.leetcode.p60;

import java.util.Arrays;

/**
 * leetcode 60 第k个排列
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {

    public String getPermutation(int n, int k) {
        int[] num = new int[10];
        int[] fact = new int[10];
        Arrays.fill(fact, 1);
        for (int i = 1; i <= 9; i++) {
            num[i - 1] = i;
            fact[i] = fact[i - 1] * i;
        }
        StringBuilder s = new StringBuilder();
        k--;
        while (n-- > 0) {
            // 查找阶乘所在数
            int d = k / fact[n];
            // 查找偏移量
            k %= fact[n];
            s.append((char) ('0' + num[d]));
            for (int i = d + 1; i <= 9; i++) {
                num[i - 1] = num[i];
            }
        }
        return s.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getPermutation(3, 3));
    }
}
