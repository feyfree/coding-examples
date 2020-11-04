package com.feyfree.design.chain.purchase;

public class President extends Approver {
    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 15000) {
            System.out.println("总裁" + "审批采购单" + "_金额" + request.getAmount());
        } else {
            this.successor.processRequest(request);
        }
    }
}
