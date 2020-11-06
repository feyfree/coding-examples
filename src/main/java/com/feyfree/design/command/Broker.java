package com.feyfree.design.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令调用类
 *
 * @author feyfree
 */
public class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order) {
        orderList.add(order);
    }

    public void placeOrders() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
