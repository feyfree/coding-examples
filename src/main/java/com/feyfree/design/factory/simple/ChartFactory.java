package com.feyfree.design.factory.simple;

/**
 * chart 工厂类
 *
 * @author leilei
 */
public class ChartFactory {
    public static IChartable getChart(String type) {
        IChartable chart;
        if ("line".equals(type)) {
            chart = new LineChart();
            return chart;
        }
        if ("histogram".equals(type)) {
            chart = new HistogramChart();
            return chart;
        }
        return null;
    }
}
