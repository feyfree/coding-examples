package com.feyfree.basic.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 *
 * @author leilei
 */
class SharedData {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment() throws Exception {
        lock.lock();
        try {
            // 1. 判断 多线程设计基本都是用while判断
            while (number != 0) {
                // 等待
                condition.await();
            }
            // 2. 干活
            number++;
            System.out.println(Thread.currentThread().getName() + " number");
            // 3.通知唤醒
            condition.signal();
        } catch (Exception ignored) {

        } finally {
            lock.unlock();
        }
    }


    public void decrement() throws Exception {
        lock.lock();
        try {
            // 1. 判断
            while (number == 0) {
                // 等待
                condition.await();
            }
            // 2. 干活
            number--;
            System.out.println(Thread.currentThread().getName() + " number");
            // 3.通知唤醒
            condition.signal();
        } catch (Exception ignored) {

        } finally {
            lock.unlock();
        }
    }
}

/**
 * 生产者消费者模型
 *
 * @author leilei
 */
public class ProducerConsumerDemo {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        sharedData.increment();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "A").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        sharedData.decrement();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "B").start();
    }
}
