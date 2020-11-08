package com.feyfree.classic;

/**
 * hash 抽象接口
 *
 * @author leilei
 */
public interface HashFunction {
    /**
     * 提供hash 接口
     *
     * @param str 输入
     * @return hash 值
     */
    Integer hash(Object str);
}
