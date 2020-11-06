package com.feyfree.design.strategy.demo1;

/**
 * 电影票
 *
 * @author leilei
 */
public class MovieTicket {

    private double price;

    private IDiscount discount;

    public IDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(IDiscount discount) {
        this.discount = discount;
    }

    public double getPrice() {
        return discount.calculate(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
