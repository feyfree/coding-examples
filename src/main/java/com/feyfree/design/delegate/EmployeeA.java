package com.feyfree.design.delegate;

/**
 * 员工A
 *
 * @author leilei
 */
public class EmployeeA implements IEmployee {
    @Override
    public void doing(String command) {
        System.out.println("I am A, I am doing " + command + " work!");
    }
}
