package com.feyfree.others;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class TestReentrantLock {

    private static final Lock lock = new ReentrantLock();

    @Test
    public void testLock1() {
        new Thread(this::test, "Thread A").start();
        new Thread(this::test, "Thread B").start();
        new Thread(this::test, "Thread C").start();
        new Thread(this::test, "Thread D").start();
        new Thread(this::test, "Thread E").start();
    }

    public void test() {
        for (int i = 0; i < 5; i++) {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "get the lock");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
