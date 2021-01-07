package com.feyfree.design.delegate;

public class EmployeeB implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("I am B, I am doing " + command + " work!");
    }
}
