package com.feyfree.design.observer.demo2;

public class Client {
    public static void main(String[] args) {
        GPer gper = GPer.getInstance();
        Teacher tom = new Teacher("Tom");
        Teacher mic = new Teacher("Mic");
        gper.addObserver(tom);
        gper.addObserver(mic);

        Question question = new Question();
        question.setUsername("小明");
        question.setContent("世界有多大");

        gper.publishQuestion(question);
    }
}
