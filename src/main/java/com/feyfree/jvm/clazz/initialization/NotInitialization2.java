package com.feyfree.jvm.clazz.initialization;

/**
 * 被动引用, 通过数组定义来饮用类， 不会出发此类的初始化
 *
 * @author leilei
 */
public class NotInitialization2 {
    public static void main(String[] args) {
        SuperClass[] classes = new SuperClass[10];
    }
}
