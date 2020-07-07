package com.feyfree.classic;

import com.feyfree.algs4.Queue;
import com.feyfree.algs4.StdOut;

/**
 * 约瑟夫环问题
 * <p>
 * 环形列表简化成一个队列的问题
 * 相对运动 表盘在动 指针不动
 * interval: m
 * total: n
 * m - 1 次循环将其dequeue 然后 enqueue 将m 位的
 *
 * @author leilei
 */
public class Josephus {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);

        // initialize the queue
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }

        while (!queue.isEmpty()) {
            for (int i = 0; i < m - 1; i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
    }
}