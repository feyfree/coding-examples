package com.feyfree.basic.generics.demo1;


/**
 * 比较最大值
 *
 * @author leilei
 */
public class MaximumTest {
    /**
     * 返回最大值
     *
     * @param x   入参
     * @param y   入参
     * @param z   入参
     * @param <T> 泛型
     * @return T 泛型
     */
    public static <T extends Comparable<T>> T maximum(T x, T y, T z) {
        T max = x;
        if (y.compareTo(max) > 0) {
            max = y;
        }
        if (z.compareTo(max) > 0) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.printf("%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum(3, 4, 5));

        System.out.printf("%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum(6.6, 8.8, 7.7));

        System.out.printf("%s, %s 和 %s 中最大的数为 %s\n", "pear",
                "apple", "orange", maximum("pear", "apple", "orange"));
    }
}