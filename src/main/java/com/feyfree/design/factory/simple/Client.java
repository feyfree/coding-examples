package com.feyfree.design.factory.simple;

/**
 * 调用示例
 *
 * @author leilei
 */
public class Client {
    public static void main(String[] args) {
        IChart chart = ChartFactory.getChart("line");
        if (chart != null) {
            chart.display();
        }
    }
}
