package com.feyfree.basic.concurrent;


import lombok.SneakyThrows;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {
    Lock lock = new ReentrantLock();

    public synchronized void sendSMS() throws Exception {
        System.out.println(Thread.currentThread().getName() + " send one message!");
        sendEmail();
    }

    public synchronized void sendEmail() throws Exception {
        System.out.println(Thread.currentThread().getName() + " send one email!");
    }

    @Override
    public void run() {
        get();
    }

    public void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " invoke get()");
            set();
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " invoke set()");
        } finally {
            lock.unlock();
        }
    }
}

/**
 * @author leilei
 */
public class ReentrantLockExample {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                phone.sendSMS();
            }
        }, "t1").start();
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                phone.sendSMS();
            }
        }, "t2").start();

        Thread.sleep(1000);

        Thread t3 = new Thread(phone);
        Thread t4 = new Thread(phone);
        t3.start();
        t4.start();

        Thread.sleep(1000);

    }
}
