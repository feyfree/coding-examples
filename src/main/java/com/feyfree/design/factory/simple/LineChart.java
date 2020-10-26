package com.feyfree.design.factory.simple;

/**
 * 折现图
 *
 * @author leilei
 */
public class LineChart implements IChartable {
    public LineChart() {
        System.out.println("Creating a line chart!");
    }

    /**
     * 展示接口
     */
    @Override
    public void display() {
        System.out.println("This is a line chart!");
    }
}
