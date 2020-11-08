package com.feyfree.classic.loadbalance;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 最小活跃数负载均衡
 * <p>
 * 进来的时候active + 1
 * 出去的时候active - 1
 * <p>
 * 参照dubbo 的写简单原理
 * http://dubbo.apache.org/zh-cn/docs/2.7/source_code_guide/loadbalance/
 *
 * @author leilei
 */
public class LeastActiveLoadBalance extends AbstractLoadBalance {

    /**
     * 活跃数 map容器
     * <p>
     * key:invoker id
     * value: Pair<活跃数, 权重>
     */
    private ConcurrentMap<String, Pair<Integer, Integer>> activeMap;

    private List<Invoker> invokers = new ArrayList<>();

    private final Random random = new Random();

    /**
     * 初始化权重
     *
     * @param data 权重列表
     */
    @Override
    public void initData(List<Pair<String, Integer>> data) {
        activeMap = new ConcurrentHashMap<>();
        for (Pair<String, Integer> item : data) {
            activeMap.put(item.getLeft(), Pair.of(0, item.getRight()));
        }
    }

    public void initDataFromInvokers(List<Invoker> invokers) {
        this.invokers = invokers;
    }

    /**
     * 抽象方法 获取
     *
     * @return 获取
     */
    @Override
    public String getInvoker() {
        return null;
    }

    /**
     * 抽象方法 根据invoker 获取
     *
     * @param invokers 提供的invokers
     * @return 返回的invoker
     */
    @Override
    public Invoker getInvoker(List<Invoker> invokers) {
        List<Invoker> least = new ArrayList<>();
        Invoker minActive = invokers.get(0);
        boolean sameWeight = true;
        int totalWeight = 0;
        for (int i = 0; i < invokers.size(); i++) {
            // 找到invoker 里面最小的active 如果集合数只有1 个立刻返回
            Invoker invoker = invokers.get(i);
            totalWeight += invoker.getWeight();
            if (invoker.getActive() < minActive.getActive() && !least.isEmpty()) {
                least.clear();
                least.add(invoker);
                minActive = invoker;
                sameWeight = false;
            } else if (invoker.getActive().equals(minActive.getActive())) {
                least.add(invoker);
            } else {
                sameWeight = false;
            }
        }
        if (sameWeight) {
            int i = random.nextInt(totalWeight);
            int temp = 0;
            for (Invoker invoker : invokers) {
                if (temp >= i) {
                    return invoker;
                }
                temp += invoker.getWeight();
            }
        }
        if (!least.isEmpty()) {
            return least.get(random.nextInt(least.size()));
        }
        return minActive;
    }
}
