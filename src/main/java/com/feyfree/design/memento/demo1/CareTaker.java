package com.feyfree.design.memento.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 负责从 Memento 中恢复对象的状态
 *
 * @author leilei
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}