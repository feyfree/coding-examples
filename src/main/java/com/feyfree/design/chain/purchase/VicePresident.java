package com.feyfree.design.chain.purchase;

public class VicePresident extends Approver {
    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 10000) {
            System.out.println("副总裁" + "审批采购单" + "_金额" + request.getAmount());
        } else {
            this.successor.processRequest(request);
        }
    }

    public VicePresident(String name) {
        super(name);
    }
}
