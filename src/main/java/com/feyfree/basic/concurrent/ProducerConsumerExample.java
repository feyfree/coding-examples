package com.feyfree.basic.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean flag = true;

    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProducer() throws Exception {
        String data = null;
        boolean returnVal;
        while (flag) {
            data = atomicInteger.incrementAndGet() + "";
            returnVal = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
            if (returnVal) {
                System.out.println(Thread.currentThread().getName() + " 插入队列 " + data + " 成功！");
            } else {
                System.out.println(Thread.currentThread().getName() + " 插入队列 " + data + " 失败！");
            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName() + "生产结束");
    }


    public void myConsumer() throws Exception {
        while (flag) {
            String result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (result == null || "".equalsIgnoreCase(result)) {
                flag = false;
                System.out.println(Thread.currentThread().getName() + '\t' + "超过预定时间2s, 消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + " 消费队列 " + result + "成功");
        }
    }

    public void stop() {
        this.flag = false;
        System.out.println("消费者-生产者应用程序叫停");
    }
}

/**
 * 生产者消费者模型
 *
 * @author leilei
 */
public class ProducerConsumerExample {
    public static void main(String[] args) throws InterruptedException {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(5));
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
                try {
                    myResource.myProducer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Producer").start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
                try {
                    myResource.myConsumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "Consumer").start();

        TimeUnit.SECONDS.sleep(10);
        myResource.stop();
    }
}
