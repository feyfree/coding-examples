package com.feyfree.others;

/**
 * hello world
 *
 * 线程number：0 = Reference Handler  计算对象是否可达
 * 线程number：1 = Finalizer 回收对象时触发的finalize 方法
 * 线程number：2 = Signal Dispatcher 线程调度员
 * 线程number：3 = Attach Listener
 * 线程number：4 = main
 * 线程number：5 = Monitor Ctrl-Break 跟IDEA 有关
 *
 * @author leilei
 */
public class HowManyThread {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("hello world");
        Thread.sleep(100000);
        ThreadGroup group = Thread.currentThread().getThreadGroup();
        ThreadGroup topGroup = group;
        while (group != null) {
            topGroup = group;
            group = group.getParent();
        }
        assert topGroup != null;
        int nowThreads = topGroup.activeCount();
        Thread[] lstThreads = new Thread[nowThreads];
        topGroup.enumerate(lstThreads);
        for (int i = 0; i < nowThreads; i++) {
            System.out.println("线程number：" + i + " = " + lstThreads[i].getName());
        }
    }
}
