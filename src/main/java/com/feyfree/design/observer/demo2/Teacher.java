package com.feyfree.design.observer.demo2;

import java.util.Observable;
import java.util.Observer;

public class Teacher implements Observer {
    private String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        GPer gper = (GPer) o;
        Question question = (Question) arg;
        System.out.println("===============");
        System.out.println(name + "老师你好");
        System.out.println(gper.getName());
        System.out.println(question.toString());
    }
}
