package com.feyfree.design.observer.demo2;

import java.util.Observable;

public class GPer extends Observable {
    private String name = "Gper生态圈";
    private static GPer gper = null;

    public GPer() {
    }

    public static GPer getInstance() {
        if (null == gper) {
            gper = new GPer();
        }
        return gper;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.toString());
        setChanged();
        notifyObservers(question);
    }
}

