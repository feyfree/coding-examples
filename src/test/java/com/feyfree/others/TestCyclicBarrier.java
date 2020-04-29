package com.feyfree.others;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestCyclicBarrier {

    @Test
    public void testCyclicBarrier() {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("发令枪响了，跑！"));
        for (int i = 0; i < 5; i++) {
            new MyThread1(barrier, "运动员" + i + "号").start();
        }
    }

    @Test
    public void testCyclicBarrier2() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("发令枪响了，跑！");

            }
        });

        for (int i = 0; i < 5; i++) {
            new MyThread2(barrier, "运动员" + i + "号", i).start();
        }
        Thread.sleep(1000);
        barrier.reset();
    }
}

class MyThread1 extends Thread {
    private final CyclicBarrier cyclicBarrier;
    private final String name;

    public MyThread1(CyclicBarrier cyclicBarrier, String name) {
        super();
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + "开始准备");
        try {
            sleep(5000);
            System.out.println(name + "准备完毕！等待发令枪");
            try {
                cyclicBarrier.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
}

class MyThread2 extends Thread {
    private final CyclicBarrier cyclicBarrier;
    private final String name;
    private final int ID;

    public MyThread2(CyclicBarrier cyclicBarrier, String name, int ID) {
        super();
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.ID = ID;

    }

    @Override
    public void run() {
        System.out.println(name + "开始准备");
        try {
            Thread.sleep(ID * 1000);  //不同运动员准备时间不一样，方便模拟不同情况
            System.out.println(name + "准备完毕！在起跑线等待发令枪");
            try {
                cyclicBarrier.await();
                System.out.println(name + "跑完了路程！");
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
                System.out.println(name + "看不见起跑线了");
            }
            System.out.println(name + "退场！");
        } catch (InterruptedException e) {

            e.printStackTrace();
        }

    }

}
