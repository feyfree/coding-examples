package com.feyfree.basic.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                atomicReference.compareAndSet(100, 101);
                atomicReference.compareAndSet(101, 100);
            }
        }, "t1").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println(atomicReference.compareAndSet(100, 200));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();

        Thread.sleep(3000);
        System.out.println("----AtomicStampedReference解决ABA问题----");

        new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                try {
                    Thread.sleep(1000);
                    atomicStampedReference.compareAndSet(100, 101, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                    atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t3").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                int stamp = atomicStampedReference.getStamp();
                try {
                    Thread.sleep(3000);
                    System.out.println(atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t4").start();
    }
}
