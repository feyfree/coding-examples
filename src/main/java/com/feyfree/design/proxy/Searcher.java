package com.feyfree.design.proxy;

/**
 * 抽象查询接口
 *
 * @author leilei
 */
public interface Searcher {

    String doSearch(String userId, String keyword);
}
