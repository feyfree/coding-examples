package com.feyfree.basic.functional.demo5;


import com.google.common.base.Joiner;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


/**
 * 为什么parallelStream默认的并发线程数要比CPU处理器的数量少1个？
 * 文章的开始已经提过了。因为最优的策略是每个CPU处理器分配一个线程，然而主线程也算一个线程，所以要占一个名额
 */
public class Main {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println("processors: " + processors);
        IntStream list = IntStream.range(0, 10);
        Set<Thread> threadSet = new HashSet<>();
        //开始并行执行
        list.parallel().forEach(i -> {
            Thread thread = Thread.currentThread();
            System.err.println("integer：" + i + "，" + "currentThread:" + thread.getName());
            threadSet.add(thread);
        });
        System.out.println("all threads：" + Joiner.on("，").join(threadSet.stream().map(Thread::getName).collect(Collectors.toList())));
        System.out.println(ForkJoinPool.getCommonPoolParallelism());

        // 设置全局并行流并发线程数
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "20");
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
    }
}
