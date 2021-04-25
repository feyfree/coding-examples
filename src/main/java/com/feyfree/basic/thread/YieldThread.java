package com.feyfree.basic.thread;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class YieldThread {
    private static final Map<String, AtomicInteger> COUNT = new ConcurrentHashMap<>();

    static class Y implements Runnable {
        private final String name;
        private final boolean isYield;

        public Y(String name, boolean isYield) {
            this.name = name;
            this.isYield = isYield;
        }

        @Override
        public void run() {
            long l = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                if (isYield) {
                    Thread.yield();
                }
                AtomicInteger atomicInteger = COUNT.get(name);
                if (null == atomicInteger) {
                    COUNT.put(name, new AtomicInteger(1));
                    continue;
                }
                atomicInteger.addAndGet(1);
                COUNT.put(name, atomicInteger);
            }
            System.out.println("线程编号：" + name + " 执行完成耗时：" + (System.currentTimeMillis() - l) + " (毫秒) " + (isYield ? " 让出 CPU -------------- --------" : " 不让 CPU "));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            if (i < 10) {
                new Thread(new Y(String.valueOf(i), true)).start();
                continue;
            }
            new Thread(new Y(String.valueOf(i), false)).start();
        }
    }
}
