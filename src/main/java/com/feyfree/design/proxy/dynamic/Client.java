package com.feyfree.design.proxy.dynamic;

public class Client {
    public static void main(String[] args) throws Exception {
        Person obj = (Person) new JDKMeipo().getInstance(new Customer());
        obj.findLove();
    }
}
