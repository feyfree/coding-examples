package com.feyfree.basic.object;

import org.junit.Test;

public class TestStatic {

    @Test
    public void test() {
        Classroom classroom = new Classroom();
        Classroom.myClass.setName("Sad");
        System.out.println(Classroom.myClass.getName());
        Classroom classroom1 = new Classroom();
        System.out.println(Classroom.myClass.getName());
    }
}
