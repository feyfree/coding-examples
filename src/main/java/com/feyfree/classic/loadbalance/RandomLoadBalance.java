package com.feyfree.classic.loadbalance;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机的访问
 *
 * @author leilei
 */
public class RandomLoadBalance extends AbstractLoadBalance {

    private List<Pair<String, Integer>> weights;
    private final List<String> invokers = new ArrayList<>();

    private final Random random = new Random();

    /**
     * 初始化权重
     *
     * @param weights 权重列表
     */
    @Override
    public void initData(List<Pair<String, Integer>> weights) {
        this.weights = weights;
        for (Pair<String, Integer> invoker : weights) {
            Integer weight = invoker.getRight();
            while (weight-- > 0) {
                invokers.add(invoker.getLeft());
            }
        }
    }

    /**
     * 抽象方法 获取
     *
     * @return 获取
     */
    @Override
    public String getInvoker() {
        int totalWeight = 0;
        for (Pair<String, Integer> weight : weights) {
            totalWeight += weight.getRight();
        }
        return invokers.get(random.nextInt(totalWeight));
    }

    /**
     * 抽象方法 根据invoker 获取
     *
     * @param invokers 提供的invokers
     * @return 返回的invoker
     */
    @Override
    public Invoker getInvoker(List<Invoker> invokers) {
        return null;
    }
}
