package com.feyfree.basic.concurrent.thread;

import lombok.SneakyThrows;

/**
 * 线程示例
 *
 * @author leilei
 */
public class ThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    @SneakyThrows
                    @Override
                    public void run() {
                        String data = ThreadDemo.run();
                        System.out.println(data);
                    }
                }, "t1-1").start();
                System.out.println("");
            }
        }, "t1");
        t1.start();
        System.out.println("I am here!");
        System.out.println(Thread.currentThread().isDaemon());
    }

    public static String run() {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(5000);
            }
        }, "A").start();
        return "Happy";
    }
}
