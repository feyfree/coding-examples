package com.feyfree.design.decorator;

/**
 * 装饰器类里面保存 原对象的引用
 *
 * @author leilei
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    public void draw() {
        decoratedShape.draw();
    }
}