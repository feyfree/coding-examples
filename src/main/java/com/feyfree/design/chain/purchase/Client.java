package com.feyfree.design.chain.purchase;

public class Client {
    public static void main(String[] args) {
        Approver andy = new Director("Andy");
        Approver jacky = new VicePresident("Jacky");
        Approver ashin = new President("Ashin");
        Approver meeting = new Congress("Congress");

        andy.setSuccessor(jacky);
        jacky.setSuccessor(ashin);
        ashin.setSuccessor(meeting);

        PurchaseRequest request = PurchaseRequest.builder().amount(5).purpose("购买办公器材").number("123").build();
        andy.processRequest(request);
    }
}
