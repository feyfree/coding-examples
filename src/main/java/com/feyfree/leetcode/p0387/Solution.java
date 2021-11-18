package com.feyfree.leetcode.p0387;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 * 387. 字符串中的第一个唯一字符
 *
 * @author leilei
 */
public class Solution {
    public int firstUniqChar(String s) {
        // count index
        int[][] container = new int[26][2];
        // Arrays.fill 数组的时候, 如果fill不是基本数据类型的话, 使用的都是同一个对象
        for (int i = 0; i < container.length; i++) {
            container[i] = new int[]{0, -1};
        }
        for (int i = 0; i < s.length(); i++) {
            int ci = s.charAt(i) - 'a';
            boolean first = container[ci][0] == 0;
            container[ci][0] += 1;
            if (first) {
                container[ci][1] = i;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int[] data : container) {
            if (data[0] == 1) {
                result = Math.min(data[1], result);
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.firstUniqChar("leetcode");
        System.out.println(i);
    }
}
