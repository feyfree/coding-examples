package com.feyfree.leetcode.p6;


import java.util.Arrays;

/**
 * zigzag conversion
 * Z 字形 变换输出
 * <p>
 * 思路
 * <p>
 * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
 * <p>
 * 从左到右迭代 ss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
 * <p>
 * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
 *
 * @author leilei
 */
public class Solution {

    public String convert(String s, int numRows) {
        // corner case
        if (numRows == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        // length of string
        int len = s.length();
        // create an array of strings for all n rows
        String[] array = new String[numRows];
        Arrays.fill(array, "");

        // initialize index for array of strings arr[]
        int row = 0;
        boolean down = true;

        for (int i = 0; i < len; i++) {
            array[row] += chars[i];
            // if last rowe is reached, change direction to up
            if (row == numRows - 1) {
                down = false;
            } else if (row == 0) {
                down = true;
            }
            if (down) {
                row++;
            } else {
                row--;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String a : array) {
            stringBuilder.append(a);
        }
        return stringBuilder.toString();
    }
}
