package com.feyfree.design.proxy.search;

public class Client {
    public static void main(String[] args) {
        Searcher searcher = new ProxySearcher();
        String result = searcher.doSearch("tom", "hi");
        System.out.println(result);
    }
}
