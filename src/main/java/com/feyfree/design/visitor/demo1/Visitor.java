package com.feyfree.design.visitor.demo1;

/**
 * 访问者接口
 *
 * @author leilei
 */
public interface Visitor {
    /**
     * 声明一组重载的访问方法，用于访问不同类型的具体元素
     *
     * @param engine 对象
     */
    void visit(Engine engine);

    /**
     * 声明一组重载的访问方法，用于访问不同类型的具体元素
     *
     * @param body 对象
     */
    void visit(Body body);

}
