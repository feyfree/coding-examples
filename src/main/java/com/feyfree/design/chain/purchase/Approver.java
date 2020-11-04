package com.feyfree.design.chain.purchase;

/**
 * 抽象类
 *
 * @author leilei
 */
public abstract class Approver {

    protected Approver successor;

    protected String name;

    public Approver(String name) {
        this.name = name;
    }

    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }

    public abstract void processRequest(PurchaseRequest request);
}
