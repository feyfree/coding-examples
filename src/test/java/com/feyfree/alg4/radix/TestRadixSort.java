package com.feyfree.alg4.radix;

import com.feyfree.algs4.MSD;
import org.junit.Test;

import java.util.Arrays;

public class TestRadixSort {

    @Test
    public void testMSD() {
        String[] data = {"see", "shell", "seashell", "ao", "ae", "sea"};
        MSD.sort(data);
        System.out.println(Arrays.toString(data));
    }
}
