package com.feyfree.leetcode.p0476;

/**
 * https://leetcode-cn.com/problems/number-complement/
 *
 * @author leilei
 */
public class Solution {
    public int findComplement(int num) {
        // 判断num的二进制长度
        int index = 0;
        int result = 0;
        while (num > 0) {
            int mod = num & 1;
            if (mod == 0) {
                result += 1 << index;
            }
            num = num >> 1;
            index++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findComplement(Integer.MAX_VALUE));

    }
}
