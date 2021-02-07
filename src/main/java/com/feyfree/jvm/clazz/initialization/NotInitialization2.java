package com.feyfree.jvm.clazz.initialization;

/**
 * 被动引用
 *
 * @author leilei
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] classes = new SuperClass[10];
    }
}
