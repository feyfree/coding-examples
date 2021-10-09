package com.feyfree.leetcode.p0278;

/**
 * @author leilei
 */
class VersionControl {
    /**
     * 随便写的方便编译通过
     *
     * @param version
     * @return
     */
    boolean isBadVersion(int version) {
        return System.currentTimeMillis() % 2 == 1;
    }
}

/**
 * https://leetcode-cn.com/problems/first-bad-version/
 * 278. 第一个错误的版本
 *
 * @author leilei
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start = 1, end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}
