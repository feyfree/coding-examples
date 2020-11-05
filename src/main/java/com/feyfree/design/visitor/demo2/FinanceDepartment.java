package com.feyfree.design.visitor.demo2;

/**
 * 财务部门
 *
 * @author feyfree
 */
public class FinanceDepartment extends Department {
    @Override
    public void visit(FullTimeEmployee employee) {
        String result = "财务部门全职员工%s工作时间:%s小时, 所得薪水%s元";
        System.out.println(
                String.format(result, employee.getName(),
                        employee.getWorkTime(),
                        employee.getWorkTime() * employee.getWeeklyWage()));
    }

    @Override
    public void visit(PartTimeEmployee employee) {
        String result = "财务部门兼职员工%s工作时间:%s小时, 所得薪水%s元";
        System.out.println(
                String.format(result, employee.getName(),
                        employee.getWorkTime(),
                        employee.getWorkTime() * employee.getWeeklyWage() * 0.7));
    }
}
