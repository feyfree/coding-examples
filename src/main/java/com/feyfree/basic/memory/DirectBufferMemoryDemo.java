//package com.feyfree.basic.memory;
//
// m1 azul jdk 会有问题
//import sun.misc.VM;
//
//import java.nio.ByteBuffer;
//
///**
// * 堆外内存
// *
// * @author leilei
// */
//public class DirectBufferMemoryDemo {
//    public static void main(String[] args) {
//        String memory = (VM.maxDirectMemory() / (double) 1024 / 1024) + "MB";
//        System.out.println("配置的最大的堆外内存:" + memory);
//
//        while (true) {
//            ByteBuffer bb = ByteBuffer.allocateDirect(100 * 1024 * 1024);
//        }
//    }
//}
