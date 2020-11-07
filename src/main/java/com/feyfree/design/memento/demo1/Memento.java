package com.feyfree.design.memento.demo1;

/**
 * 备忘录
 *
 * @author leilei
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}