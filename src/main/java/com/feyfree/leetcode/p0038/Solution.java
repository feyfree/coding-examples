package com.feyfree.leetcode.p0038;

/**
 * 38. 外观数列
 * <p>
 * 给定一个正整数 n（1 ≤n≤ 30），输出外观数列的第 n 项。
 * <p>
 * 注意：整数序列中的每一项将表示为一个字符串。
 * <p>
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * <p>
 * 第一项是数字 1
 * <p>
 * 描述前一项，这个数是 1 即 “一个 1 ”，记作 11
 * <p>
 * 描述前一项，这个数是 11 即 “两个 1 ” ，记作 21
 * <p>
 * 描述前一项，这个数是 21 即 “一个 2 一个 1 ” ，记作 1211
 * <p>
 * 描述前一项，这个数是 1211 即 “一个 1 一个 2 两个 1 ” ，记作 111221
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author leilei
 * @date 2020/8/14 17:08
 */
public class Solution {
    public String countAndSay(int n) {
        String temp = "1";
        while (n - 1 > 0) {
            temp = generateNext(temp);
            --n;
        }
        return temp;
    }

    /**
     * 根据当前的值, 构造下一个值
     *
     * @param init 当前的值
     * @return 构造下一个值
     */
    public String generateNext(String init) {
        StringBuilder result = new StringBuilder();
        Character before = null;
        int count = 0;
        for (int i = 0; i < init.length(); i++) {
            if (before == null || before == init.charAt(i)) {
                count += 1;
            } else {
                result.append(count).append(before);
                count = 1;
            }
            before = init.charAt(i);
        }
        if (count > 0) {
            result.append(count).append(before);
        }
        return result.toString();
    }
}
