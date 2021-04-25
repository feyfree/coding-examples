package com.feyfree.basic.thread;

import lombok.SneakyThrows;
import org.junit.Test;

public class TestThread {

    @Test
    public void testJoin() throws InterruptedException {
        Thread a = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("This is a");
        });

        Thread b = new Thread(() -> System.out.println("This is b"));

        Thread c = new Thread(() -> System.out.println("This is c"));
        a.start();
        a.join();
        b.start();
        b.join();
        c.start();
        c.join();
    }

    @Test
    public void testNew() {
        Thread one = new Thread(() -> {
        });
//        one.start();
        System.out.println(one.getState());
    }

    @Test
    public void testRunnable() {
        Thread one = new Thread(() -> {
            System.out.println("This is a test");
        });
        one.start();
        System.out.println(one.getState());
    }

    /**
     * 测试阻塞
     * <p>
     * output:
     * BLOCKED
     * BLOCKED
     * BLOCKED
     * BLOCKED
     * BLOCKED
     * BLOCKED
     * BLOCKED
     * BLOCKED
     * BLOCKED
     * WAITING
     * WAITING
     * WAITING
     * ......
     *
     * @throws InterruptedException 异常
     */
    @Test
    public void testBlocked() throws InterruptedException {
        Object obj = new Object();
        new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread thread = new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while (true) {
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }

    }

    @Test
    public void testWaiting() throws InterruptedException {
        Object obj = new Object();
        Thread thread = new Thread(() -> {
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while (true) {
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
    }


    @Test
    public void testTimedWaiting() throws InterruptedException {
        Object obj = new Object();
        Thread thread = new Thread(() -> {
            synchronized (obj) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        while (true) {
            Thread.sleep(1000);
            System.out.println(thread.getState());
        }
    }


}
