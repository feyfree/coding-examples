package com.feyfree.leetcode.p0043;


import java.util.Arrays;

/**
 * p43 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 说明：
 * <p>
 * num1和num2的长度小于110。
 * num1 和num2 只包含数字0-9。
 * num1 和num2均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multiply-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {

    public String multiply(String num1, String num2) {
        int l1 = num1.length();
        int l2 = num2.length();
        char[] result = new char[l1 + l2];
        Arrays.fill(result, '0');
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int sum = result[i + j + 1] - '0' + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] = (char) ((sum % 10) + '0');
                result[i + j] += sum / 10;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] != '0' || i == result.length - 1) {
                return String.valueOf(result, i, result.length - i);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 = "456";
        Solution solution = new Solution();
        System.out.println(solution.multiply(num1, num2));
    }
}
