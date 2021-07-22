package com.feyfree.basic.concurrent.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池示例
 *
 * @author leilei
 */
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> System.out.println(Thread.currentThread().getName() + " 办理业务"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
