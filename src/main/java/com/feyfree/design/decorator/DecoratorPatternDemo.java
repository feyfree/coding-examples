package com.feyfree.design.decorator;

import java.util.ArrayList;
import java.util.List;

/**
 * 装饰器模式
 * demo
 *
 * @author leilei
 */
public class DecoratorPatternDemo {
    public static void main(String[] args) {

        Shape circle = new Circle();
        // 类型实际上还是Shape 也可以用 ShapeDecorator
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        //Shape redCircle = new RedShapeDecorator(new Circle());
        //Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();

        List<Shape> data = new ArrayList<>();
        data.add(redCircle);
        data.get(0).draw();
    }

}
