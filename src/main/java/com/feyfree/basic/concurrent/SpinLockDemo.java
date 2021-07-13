package com.feyfree.basic.concurrent;

import lombok.SneakyThrows;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁例子
 *
 * @author leilei
 */
public class SpinLockDemo {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " try to lock!");
        while (!atomicReference.compareAndSet(null, thread)) {

        }
        System.out.println(thread.getName() + " get one lock");
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " unlock!");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) throws InterruptedException {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                spinLockDemo.lock();
                Thread.sleep(5000);
                spinLockDemo.unlock();
            }
        }, "A").start();
        Thread.sleep(100);
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                spinLockDemo.lock();
                Thread.sleep(300);
                spinLockDemo.unlock();
            }
        }, "B").start();
    }
}
