package com.feyfree.design.builder;

/**
 * 实物条目
 *
 * @author leilei
 */
public interface Item {
    public String name();

    public Packing packing();

    public float price();
}