package com.feyfree.questions;

import lombok.SneakyThrows;

/**
 * Notify Wait 测试
 * <p>
 * 调用notify或notifyAll方法后，当前线程并不会立即放弃锁的持有权，
 * 而必须要等待当前同步代码块执行完或者调用了wait方法才会让出锁资源
 * <p>
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
                    OBJ.notifyAll();

                    while (count <= 5) {
                        System.out.println("线程1");
                        System.out.println(count++);
                    }
                    OBJ.wait(100);

                    System.out.println("线程1END");
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                synchronized (OBJ) {
                    OBJ.notifyAll();
                    while (count <= 5) {
                        System.out.println("线程2");
                        System.out.println(count++);
                    }
                    OBJ.wait(100);
                    System.out.println("线程2END");

                }

            }
        });
        t1.start();
        t2.start();
        System.out.println("Over");
    }
}
