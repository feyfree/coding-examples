package com.feyfree.leetcode.p0461;


/**
 * 使用lowBit 的升级版
 *
 * @author leilei
 */
public class AdvancedSolution {
    public int hammingDistance(int x, int y) {
        int result = x ^ y;
        int distance = 0;
        while (result != 0) {
            distance++;
            result = deleteLowBit(result);
        }
        return distance;
    }

    /**
     * lowBit 算出最后一位的1代表的数字
     *
     * @param n 数字
     * @return 最后一位的1代表的值
     */
    private int lowBit(int n) {
        return n & -n;
    }


    /**
     * 删去其二进制表示中最右侧的 1 的结果
     *
     * @param n
     * @return
     */
    private int deleteLowBit(int n) {
        return n & n - 1;
    }
}
