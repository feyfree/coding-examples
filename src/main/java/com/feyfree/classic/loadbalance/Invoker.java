package com.feyfree.classic.loadbalance;

import lombok.Data;

/**
 * 服务抽象
 *
 * @author leilei
 */
@Data
public class Invoker {
    /**
     * invoker 名称
     */
    private String name;

    /**
     * invoker 权重数
     */
    private Integer weight;

    /**
     * invoke 的 活跃数
     */
    private Integer active;
}
