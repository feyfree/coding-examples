package com.feyfree.jvm.clazz;

public class ArrayType {
    public static void main(String[] args) {
        int[] a = {1, 2};
        System.out.println(a.getClass().getComponentType());

        String[] b = new String[]{"1", "2"};
        System.out.println(b.getClass().getComponentType());

    }
}
