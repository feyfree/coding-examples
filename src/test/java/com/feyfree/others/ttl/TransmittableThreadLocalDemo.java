package com.feyfree.others.ttl;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import com.alibaba.ttl.threadpool.TtlExecutors;

import java.util.Objects;
import java.util.concurrent.*;

/**
 * alibaba TransmittableThreadLocal示例
 *
 * @author leilei
 */
public class TransmittableThreadLocalDemo {

    private ExecutorService executorService;
    private final TransmittableThreadLocal<String> ttl = new TransmittableThreadLocal<>();


    private void practice() throws InterruptedException, ExecutionException {
        // 避免 创建线程池的 线程相同
        Thread thread = new Thread(() -> executorService = Executors.newFixedThreadPool(5));
        thread.start();
        Thread.sleep(3000);
        ttl.set("value set here");
        Runnable runnable = () -> {
            String s = ttl.get();
            System.out.println(s);
        };
        TtlRunnable ttlRunnable = TtlRunnable.get(runnable);
        if (ttlRunnable != null) {
            executorService.submit(ttlRunnable).get();
        }
        executorService.submit(runnable).get();
        ttl.set("value set again");
        executorService.submit(runnable).get();
        ttlRunnable = TtlRunnable.get(runnable);
        if (ttlRunnable != null) {
            executorService.submit(ttlRunnable).get();
        }
        executorService.shutdownNow();

    }


    private void practiceWrapperExecutors() throws InterruptedException {
        executorService = Executors.newFixedThreadPool(3);
        Executor ttlExecutor = TtlExecutors.getTtlExecutor(executorService);
        ttl.set("i am a transmittable parent");
        ttlExecutor.execute(() -> {
            System.out.println(ttl.get());
            ttl.set("set in executors");
        });
        System.out.println(ttl.get());
        TimeUnit.SECONDS.sleep(1);
        ttl.set("i am a new transmittable parent");
        ttlExecutor.execute(() -> System.out.println(ttl.get()));

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TransmittableThreadLocalDemo demo = new TransmittableThreadLocalDemo();
//        demo.practice();
        demo.practiceWrapperExecutors();
    }


}
