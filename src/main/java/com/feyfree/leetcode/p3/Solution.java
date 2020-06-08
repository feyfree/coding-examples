package com.feyfree.leetcode.p3;


import java.util.Arrays;

/**
 * longest-substring-without-repeating-characters
 * <p>
 * 最长不重复的子字符串
 * <p>
 * 对比最大的子序列的和 算法比较
 *
 * @author leilei
 */
public class Solution {

    /**
     * 所有字符的数目
     */
    static final int ALL_CHARS_NUMS = 256;

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 字符串总长度
        int totalLength = s.length();
        // 返回的结果
        int result = 0;
        // 字符 所在序列的最大序号
        int[] lastIndexArray = new int[ALL_CHARS_NUMS];
        // 默认是 -1
        Arrays.fill(lastIndexArray, -1);
        // 滑动窗口最大值
        int start = 0;
        for (int end = 0; end < totalLength; end++) {
            start = Math.max(start, lastIndexArray[s.charAt(end)] + 1);
            result = Math.max(result, end - start + 1);
            lastIndexArray[s.charAt(end)] = end ;
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
