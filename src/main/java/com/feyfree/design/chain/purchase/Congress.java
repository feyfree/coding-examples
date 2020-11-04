package com.feyfree.design.chain.purchase;

public class Congress extends Approver {
    public Congress(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        System.out.println("董事会" + "审批采购单" + "_金额" + request.getAmount());
    }
}
