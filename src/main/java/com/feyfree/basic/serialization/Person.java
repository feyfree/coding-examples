package com.feyfree.basic.serialization;

import java.io.Serializable;

// 第一次模拟
//public class Person implements Serializable {
//
//    private String firstName;
//    private String lastName;
//
//    public Person(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//}

// 第二次
public class Person implements Serializable {


    private static final long serialVersionUID = -6173492612723892538L;
    private String firstName;
    private String lastName;

    private String midName;

    public Person(String firstName, String lastName, String midName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.midName = midName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }
}