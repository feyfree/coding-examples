package com.feyfree.design.visitor.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * 具体对象集合
 *
 * @author leilei
 */
public class Car {

    private List<Visitable> visit = new ArrayList<>();

    public void addVisit(Visitable visitable) {
        visit.add(visitable);
    }

    public void show(Visitor visitor) {
        for (Visitable visitable : visit) {
            visitable.accept(visitor);
        }
    }
}