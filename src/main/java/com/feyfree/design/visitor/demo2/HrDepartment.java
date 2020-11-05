package com.feyfree.design.visitor.demo2;

/**
 * 人力资源部门
 *
 * @author leilei
 */
public class HrDepartment extends Department {
    /**
     * 访问全职员工
     *
     * @param employee 员工
     */
    @Override
    public void visit(FullTimeEmployee employee) {
        String result = "人力部门全职员工%s工作时间:%s小时, 所得薪水%s元";
        System.out.println(
                String.format(result, employee.getName(),
                        employee.getWorkTime(),
                        employee.getWorkTime() * employee.getWeeklyWage()));
    }

    /**
     * 访问兼职员工
     *
     * @param employee 员工
     */
    @Override
    public void visit(PartTimeEmployee employee) {
        String result = "人力部门兼职员工%s工作时间:%s小时, 所得薪水%s元";
        System.out.println(
                String.format(result, employee.getName(),
                        employee.getWorkTime(),
                        employee.getWorkTime() * employee.getWeeklyWage() * 0.6));
    }
}
