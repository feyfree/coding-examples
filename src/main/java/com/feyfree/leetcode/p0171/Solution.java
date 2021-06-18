package com.feyfree.leetcode.p0171;

/**
 * 171. Excel表列序号
 * https://leetcode-cn.com/problems/excel-sheet-column-number/
 *
 * @author leilei
 */
public class Solution {
    public int titleToNumber(String columnTitle) {
        int step = 0;
        int result = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int current = columnTitle.charAt(i) - 'A' + 1;
            result = result + (int) (current * Math.pow(26, step));
            step++;
        }
        return result;
    }
}
