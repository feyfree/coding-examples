package com.feyfree.design.prototype;


/**
 * 具体类
 *
 * @author feyfree
 */
public class Circle extends Shape {

    public Circle() {
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
