package com.feyfree.design.visitor;

/**
 * 具体对象
 *
 * @author feyfree
 */
public class Body implements Visitable {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}