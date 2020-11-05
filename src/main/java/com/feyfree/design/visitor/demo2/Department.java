package com.feyfree.design.visitor.demo2;

/**
 * 部门
 *
 * @author feyfree
 */
public abstract class Department {
    /**
     * 访问全职员工
     *
     * @param employee 员工
     */
    public abstract void visit(FullTimeEmployee employee);


    /**
     * 访问兼职员工
     *
     * @param employee 员工
     */
    public abstract void visit(PartTimeEmployee employee);

}
