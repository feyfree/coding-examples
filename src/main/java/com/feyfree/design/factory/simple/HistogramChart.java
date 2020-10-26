package com.feyfree.design.factory.simple;

/**
 * 柱状图
 *
 * @author leilei
 */
public class HistogramChart implements IChartable {

    public HistogramChart() {
        System.out.println("Creating a histogram chart!");
    }

    /**
     * 展示接口
     */
    @Override
    public void display() {
        System.out.println("This is a histogram chart!");
    }
}
