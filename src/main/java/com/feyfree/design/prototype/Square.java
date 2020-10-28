package com.feyfree.design.prototype;

/**
 * 具体类
 *
 * @author leilei
 */
public class Square extends Shape {

    public Square() {
        type = "Square";
    }

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}