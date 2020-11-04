package com.feyfree.design.proxy.search;

public class RealSearcher implements Searcher {
    @Override
    public String doSearch(String userId, String keyword) {
        System.out.println("Start to search");
        return "Happy";
    }
}
