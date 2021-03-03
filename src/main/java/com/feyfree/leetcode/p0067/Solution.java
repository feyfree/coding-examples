package com.feyfree.leetcode.p0067;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-binary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 */
public class Solution {
    public String addBinary(String a, String b) {
        // 预处理
        int al = a.length();
        int bl = b.length();
        if (al > bl) {
            return add(b, a);
        }
        return add(a, b);
    }

    /**
     * 两个二进制 字符串相加
     * <p>
     * 默认b.length > a.length
     *
     * @param a 字符串a
     * @param b 字符串b
     * @return 构建string
     */
    private String add(String a, String b) {
        int flag = 0;
        StringBuilder result = new StringBuilder();
        for (int offset = 0; offset < a.length(); offset++) {
            int aVal = a.charAt(a.length() - 1 - offset) - '0';
            int bVal = b.charAt(b.length() - 1 - offset) - '0';
            int cal = aVal + bVal + flag;
            flag = cal / 2;
            int calValue = cal % 2;
            result.append(calValue);
        }
        for (int offset = a.length(); offset < b.length(); offset++) {
            int bVal = b.charAt(b.length() - 1 - offset) - '0';
            int cal = bVal + flag;
            flag = cal / 2;
            int calValue = cal % 2;
            result.append(calValue);
        }
        if (flag == 1) {
            result.append(1);
        }
        result.reverse();
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}
