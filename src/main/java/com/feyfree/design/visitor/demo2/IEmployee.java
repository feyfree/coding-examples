package com.feyfree.design.visitor.demo2;

/**
 * 抽象类员工
 *
 * @author leilei
 */
public interface IEmployee {
    /**
     * 接受一个部门的处理
     *
     * @param handler 处理逻辑
     */
    void accept(Department handler);


}
