package com.feyfree.leetcode.p0009;


/**
 * 回文字符串的进阶解法
 * 不用转字符串解法
 * <p>
 * 对于数字 1221，如果执行 1221 % 10，我们将得到最后一位数字 1，要得到倒数第二位数字，
 * 我们可以先通过除以 10 把最后一位数字从 1221 中移除，1221 / 10 = 122，
 * 再求出上一步结果除以 10 的余数，122 % 10 = 2，就可以得到倒数第二位数字。
 * 如果我们把最后一位数字乘以 10，再加上倒数第二位数字，1 * 10 + 2 = 12，
 * 就得到了我们想要的反转后的数字。如果继续这个过程，我们将得到更多位数的反转数字。
 * <p>
 * 现在的问题是，我们如何知道反转数字的位数已经达到原始数字位数的一半？
 * <p>
 * 由于整个过程我们不断将原始数字除以 10，然后给反转后的数字乘上 10，
 * 所以，当原始数字小于或等于反转后的数字时，
 * 就意味着我们已经处理了一半位数的数字了。
 *
 * @author leilei
 */
public class AdvancedSolution {

    public boolean isPalindrome(int x) {
        // 需要忽略的情况
        // 1. x < 0;
        // 2. x 是 10 的倍数, 但是x != 0;
        boolean ignoredCases = x < 0 || (x % 10 == 0 && x != 0);
        if (ignoredCases) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
