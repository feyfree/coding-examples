package com.feyfree.jvm.analysis;

/**
 * gc 操作示例
 *
 * @author feyfree
 */
public class HelloGC {
    public static void main(String[] args) throws InterruptedException {
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long maxMemory = runtime.maxMemory();
        // 1/64 相对于机器内存 单位是字节
        System.out.println("total memory:" + totalMemory);
        // 1/4 相对于机器内存
        System.out.println("max memory:" + maxMemory);
        byte[] bytes = new byte[60 * 1024 * 1024];
        System.out.println("Hello GC");
//        Thread.sleep(Integer.MAX_VALUE);
    }
}
