package com.feyfree.basic.generics.demo4.chooser;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Chooser1<T> {
    private final T[] choiceArray;

    public Chooser1(Collection<T> choices) {
//        choiceArray = choices.toArray();
        choiceArray = (T[]) choices.toArray();
    }

    // choose method unchanged
    public Object choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceArray[rnd.nextInt(choiceArray.length)];
    }
}