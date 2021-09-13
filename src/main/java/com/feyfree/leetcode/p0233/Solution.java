package com.feyfree.leetcode.p0233;

/**
 * https://leetcode-cn.com/problems/number-of-digit-one/
 * 233. 数字 1 的个数
 * <p>
 * 参考: http://www.noteanddata.com/leetcode-233-Number-of-Digit-One-amazon-interview-problem-java-solution-note.html
 * <p>
 * <p>
 * 上面的数看上去已经有点规律了， 那么我们如果要求解符合题目要求的n总共有多少个1，
 * a. 假设n=2345,
 * 那么f(2345) = 1000 + f(345) + f(999) * 2
 * 相当于[0–999]之间的1会需要计数两次， 然后呢， 加上千位数的1会计数1000次。 最后， 还有345需要计数
 * b. 假设n=3568,
 * 那么f(3568) = 1000 + f(568) + f(999) * 3
 * 同理， [1000-1999]在千位数上的1有1000个， 然后， [0–999]需要计数三次，就是千位数分别数0，1，2的时候总共有三次，
 * 最后， 千位数是3的时候，568的时候需要计数。
 * c. 假设n=1729,
 * 那么f(1729) = 729+1 + f(999) + f(729)
 * 考虑千位数的时候， 千位数数1的情况和前面两个情况不太一样， 这时候， 千位数是1的数是[1000-1729], 所以总共有729+1个，
 * 然后， 千位数数0的时候， [0–999]就是f(999), 千位数是1的时候， 还有f(729)需要计数
 *
 * @author leilei
 */
public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n < 10) {
            return 1;
        }
        int based = (int) Math.pow(10, String.valueOf(n).length() - 1);
        int v = n % based;
        int firstCharacter = n / based;
        if (firstCharacter == 1) {
            return v + 1 + countDigitOne(v) + countDigitOne(based - 1);
        } else {
            return based + countDigitOne(v) + countDigitOne(based - 1) * firstCharacter;
        }
    }
}
