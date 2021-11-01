package com.feyfree.questions;

import lombok.SneakyThrows;

/**
 * Notify Wait 测试
 * <p>
 * 调用notify或notifyAll方法后，当前线程并不会立即放弃锁的持有权，
 * 而必须要等待当前同步代码块执行完或者调用了wait方法才会让出锁资源
 *
 * WARNING- 编程的时候必须保证wait方法比notify方法先执行，
 * 否则可能会导致wait方法进入休眠的线程接收不到唤醒通知的问题
 *
 * @author leilei
 */
public class NotifyWait {

    private static final Object OBJ = new Object();

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (OBJ) {
                    while (count <= 5) {
                        OBJ.notifyAll();
                        System.out.println("线程1");
                        System.out.println(count++);
                        OBJ.wait();
                    }
                    System.out.println("线程1END");
                }
            }
        });

        // 这个线程2运行起来会有问题, 因为 wait 没有超时的话,
        // t2线程一直挂起, 导致daemon线程一直无法退出
        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (OBJ) {
                    while (count <= 5) {
                        OBJ.notifyAll();
                        System.out.println("线程2");
                        System.out.println(count++);
                        OBJ.wait();
                    }
                    System.out.println("线程2END");

                }

            }
        });
        t1.start();
        t2.start();
        System.out.println("Over");
    }
}
