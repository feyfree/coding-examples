package com.feyfree.basic.operation;

import org.junit.Assert;

/**
 * 复杂的位运算
 *
 * @author leilei
 */
public class AdvancedBitOperation {
    /**
     * 判断奇偶性质  利用位运算
     * <p>
     * 现代编译器在编译阶段实际上 会将判断并优化成位运算
     *
     * @param x 输入
     * @return true 是 odd false 是even
     */
    public boolean isOdd(int x) {
        return (x & 1) == 1;
    }

    /**
     * 清零 最低位 的 1
     *
     * @param x 输入
     * @return 清零 最低位 的 1
     */
    public int removeLowestOne(int x) {
        return x & (x - 1);
    }

    /**
     * 得到最低位的 1
     *
     * @param x 输入
     * @return 输出
     */
    public int getLowestOne(int x) {
        return x & -x;
    }





    public static void main(String[] args) {
        AdvancedBitOperation operation = new AdvancedBitOperation();
        Assert.assertTrue(operation.isOdd(1));
        Assert.assertTrue(operation.isOdd(13));

        // 10000 = 18
        Assert.assertEquals(16, operation.removeLowestOne(18));

        System.out.println(operation.getLowestOne(16));
    }


}
