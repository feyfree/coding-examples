package com.feyfree.design.visitor.demo1;

/**
 * 具体对象
 *
 * @author leilei
 */
public class Engine implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}