package com.feyfree.alg4.string;

import com.feyfree.algs4.BoyerMoore;
import org.junit.Test;

public class TestSubStringSearch {

    @Test
    public void testBoyerMoore() {
        BoyerMoore boyerMoore = new BoyerMoore("ll");
        int index = boyerMoore.search("hello");
        System.out.println(index);
    }
}
