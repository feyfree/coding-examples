package com.feyfree.design.chain.purchase;

/**
 * 总监
 *
 * @author leilei
 */
public class Director extends Approver {

    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 5000) {
            System.out.println("主管" + "审批采购单" + "_金额" + request.getAmount());
        } else {
            this.successor.processRequest(request);
        }
    }
}
