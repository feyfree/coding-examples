package com.feyfree.basic.concurrent;

class LockHolder implements Runnable {

    private final String lockA;

    private final String lockB;

    public LockHolder(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.printf("当前线程%s持有%s, 准备获取%s%n", Thread.currentThread().getName(), lockA, lockB);
            synchronized (lockB) {
                System.out.printf("当前线程%s持有%s", Thread.currentThread().getName(), lockB);
            }
        }
    }
}

/**
 * 死锁示例
 *
 * @author leilei
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new Runnable() {
            @Override
            public void run() {
                LockHolder holder = new LockHolder(lockA, lockB);
                holder.run();
            }
        }, "A").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LockHolder holder = new LockHolder(lockB, lockA);
                holder.run();
            }
        }, "B").start();
    }
}
