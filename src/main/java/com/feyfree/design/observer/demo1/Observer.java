package com.feyfree.design.observer.demo1;

/**
 * @author feyfree
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}