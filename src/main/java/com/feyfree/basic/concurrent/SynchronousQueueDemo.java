package com.feyfree.basic.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * 阻塞同步队列
 *
 * @author leilei
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName() + " put 1");
                    blockingQueue.put("1");

                    System.out.println(Thread.currentThread().getName() + " put 2");
                    blockingQueue.put("2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadA").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    String one = blockingQueue.take();
                    System.out.println(Thread.currentThread().getName() + " take " + one);
//                    String two = blockingQueue.take();
//                    System.out.println(Thread.currentThread().getName() + " take " + two);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "ThreadB").start();
    }
}
