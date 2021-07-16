package com.feyfree.basic.concurrent;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("--come into callable--");
        Thread.sleep(5000);
        return 1024;
    }
}

/**
 * callable 示例
 *
 * @author leilei
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        Thread a = new Thread(futureTask, "A");
        a.start();
        // future.get() 最好放在最后
//        while (!futureTask.isDone()) {
//            System.out.println("询问任务情况!");
//        }
        System.out.println(futureTask.get());
    }
}
