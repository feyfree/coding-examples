package com.feyfree.leetcode.p0299;

/**
 * 优化解法
 * <p>
 * 我们只维护一个桶数组，这个桶数组的操作为：
 * <p>
 * 如果secret中某个数不是公牛（未在guess的相同位置找到相同字符），则桶的对应位置加一。
 * 如果guess中某个数不是公牛（未在secret的相同位置找到相同字符），则桶的对应位置减一。
 * <p>
 * 在遍历时，若secret.charAt(i) != guess.charAt(i)，做两次判断：
 * <p>
 * 如果secret.charAt(i)字符的桶位置为负数，则说明桶里一定有来自guess的未被匹配的字符，这时可以断定发现了一组奶牛，奶牛数++，同时更新该位置的数量（加一）。
 * 如果guess.charAt(i)字符的桶位置为正数，则说明桶里一定有来自secret的未被匹配的字符，这时可以断定发现了一组奶牛，奶牛数++，同时更新该位置的数量（减一）。
 *
 * @author leilei
 */
public class AdvancedSolution {
    public String getHint(String secret, String guess) {
        int[] count = new int[10];
        int a = 0, b = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                a++;
            } else {
                // 判断 guess 在 i 之前是否该数字
                if (count[secret.charAt(i) - '0']++ < 0) {
                    b++;
                }
                // 判断 secret 在 i 之前是否该数字
                if (count[guess.charAt(i) - '0']-- > 0) {
                    b++;
                }
            }
        }
        return a + "A" + b + "B";
    }
}
