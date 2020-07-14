package com.feyfree.basic.collection;

import org.junit.Test;

import java.util.Arrays;

public class TestSystemArrayCopy {

    @Test
    public void testSystemArrayCopy() {
        int[] a = new int[]{0, 1, 2, 3};
        int mid = 3;
        int[] pre = new int[mid];
        // System.arrayCopy() 中的srcPos 从该起点包含该起点的复制的
        System.arraycopy(a, 0, pre, 0, mid);
        int[] after = new int[a.length - mid];
        System.arraycopy(a, mid, after, 0, a.length - mid);
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(after));
    }
}
