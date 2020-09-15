package com.feyfree.alg4.sort;

import com.feyfree.basic.sort.MergeSortBU;
import com.feyfree.basic.sort.MergeSortTD;
import org.junit.Test;

import java.util.Arrays;

/**
 * 排序测试
 *
 * @author leilei
 */
public class TestSort {

    @Test
    public void testMergeSortBU() {
        MergeSortBU mergeSortBU = new MergeSortBU();
        int[] a = {1, 3, 2, 9, 5, 8, 7, 0};
        System.out.println(Arrays.toString(a));
        mergeSortBU.sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void testMergeSortTD() {
        MergeSortTD mergeSortTD = new MergeSortTD();
        int[] a = {1, 3, 2, 9, 5, 8, 7, 0};
        System.out.println(Arrays.toString(a));
        mergeSortTD.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
