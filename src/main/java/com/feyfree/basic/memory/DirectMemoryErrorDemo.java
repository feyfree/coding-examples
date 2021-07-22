package com.feyfree.basic.memory;

import sun.misc.VM;

/**
 * 堆外内存
 *
 * @author leilei
 */
public class DirectMemoryErrorDemo {
    public static void main(String[] args) {
        String memory = (VM.maxDirectMemory() / (double) 1024 / 1024) + "MB";
        System.out.println("配置的最大的堆外内存:" + memory);
    }
}
