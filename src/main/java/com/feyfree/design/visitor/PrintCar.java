package com.feyfree.design.visitor;

/**
 * 真正的访问者
 *
 * @author leilei
 */
public class PrintCar implements Visitor {
    @Override
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }

    @Override
    public void visit(Body body) {
        System.out.println("Visiting body");
    }

}
