package com.feyfree.design.memento.demo1;

/**
 * 创建并在 Memento 对象中存储状态
 *
 * @author leilei
 */
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveStateToMemento() {
        return new Memento(state);
    }

    public void getStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}
