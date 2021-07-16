package com.feyfree.basic.concurrent.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareResource {
    private int number = 1;

    private final Lock lock = new ReentrantLock();

    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    public void print5() {

        lock.lock();
        try {
            // 1. 判断
            while (number != 1) {
                c1.await();
            }
            // 2. 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3. 通知
            number = 2;
            c2.signal();
        } catch (Exception ignored) {
        } finally {
            lock.unlock();
        }
    }

    public void print10() {

        lock.lock();
        try {
            // 1. 判断
            while (number != 2) {
                c2.await();
            }
            // 2. 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3. 通知
            number = 3;
            c3.signal();
        } catch (Exception ignored) {
        } finally {
            lock.unlock();
        }
    }

    public void print15() {

        lock.lock();
        try {
            // 1. 判断
            while (number != 3) {
                c3.await();
            }
            // 2. 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            // 3. 通知
            number = 1;
            c1.signal();
        } catch (Exception ignored) {
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 多个condition
 *
 * @author leilei
 */
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    shareResource.print5();
                }
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    shareResource.print10();
                }
            }
        }, "B").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    shareResource.print15();
                }
            }
        }, "C").start();
    }
}
