package com.feyfree.questions;

import java.util.Arrays;

/**
 * 向量旋转解法
 * <p>
 * 编程珠玑的ch2习题3
 *
 * @author leilei
 */
public class RotateVector {

    public void reverse(int[] data, int i) {
        int n, m;
        int length = data.length;
        for (int j = 0; j < gcd(i, length); j++) {
            n = data[j];
            for (m = j + i; m != j; m = (m + i) % length) {
                data[(m - i + length) % length] = data[m];
            }
            m = (m - i + length) % length;
            data[m] = n;
        }
    }

    private int gcd(int m, int n) {
        while (m != n) {
            if (m > n) {
                m -= n;
            } else {
                n -= m;
            }
        }
        return m;
    }


    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        RotateVector rotateVector = new RotateVector();
        rotateVector.reverse(data, 4);
        System.out.println(Arrays.toString(data));
    }

    private void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
