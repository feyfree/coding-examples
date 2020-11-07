package com.feyfree.classic.loadbalance;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

/**
 * 抽象类
 *
 * @author leilei
 */
public abstract class AbstractLoadBalance {

    /**
     * 初始化权重
     *
     * @param data 权重列表
     */
    public abstract void initData(List<Pair<String, Integer>> data);

    /**
     * 抽象方法 获取
     *
     * @return 获取
     */
    public abstract String getInvoker();

    /**
     * 抽象方法 根据invoker 获取
     *
     * @param invokers 提供的invokers
     * @return 返回的invoker
     */
    public abstract Invoker getInvoker(List<Invoker> invokers);
}
