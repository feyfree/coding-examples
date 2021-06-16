package com.feyfree.leetcode.p0168;

/**
 * 168. Excel表列名称
 * https://leetcode-cn.com/problems/excel-sheet-column-title/
 *
 * @author leilei
 */
public class Solution {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            // 这一步很重要 相当于默认加上了一个 0 位
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.convertToTitle(701);
        System.out.println(result);
    }
}
