package com.feyfree.design.visitor;

/**
 * 相当于抽象元素
 *
 * @author feyfree
 */
public interface Visitable {

    /**
     * 支持访问
     *
     * @param visitor 访问者
     */
    void accept(Visitor visitor);
}
