package com.feyfree.basic.generics.demo4.chooser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 相对与其他 chooser 类型安全
 * 在运行时不会得到 ClassCastException 异常
 * <p>
 * 但是也许运行比较慢
 *
 * @author leilei
 */
public class ChooserTypeSafe<T> {
    private final List<T> choiceList;

    public ChooserTypeSafe(Collection<T> choices) {
        choiceList = new ArrayList<>(choices);
    }

    public T choose() {
        Random rnd = ThreadLocalRandom.current();
        return choiceList.get(rnd.nextInt(choiceList.size()));
    }
}