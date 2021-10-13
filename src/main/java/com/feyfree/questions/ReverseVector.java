package com.feyfree.questions;

/**
 * 向量旋转解法
 * <p>
 * 编程珠玑的ch2习题3
 *
 * @author leilei
 */
public class ReverseVector {

    public void reverse(int[] data, int i) {
        int t = data[0];
        for (int j = 0; j <= i; j++) {
            swap(data, j, (j + i) % data.length);
        }
    }

    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    }

    private void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
