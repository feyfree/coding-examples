package com.feyfree.design.builder;

/**
 * 实物条目
 *
 * @author leilei
 */
public interface Item {
    String name();

    Packing packing();

    float price();
}