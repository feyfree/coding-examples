package com.feyfree.design.strategy.demo1;

/**
 * 测试代码
 *
 * @author leilei
 */
public class Client {
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.setPrice(100);
        ticket.setDiscount(new StudentDiscount());
        System.out.println(ticket.getPrice());
    }
}
