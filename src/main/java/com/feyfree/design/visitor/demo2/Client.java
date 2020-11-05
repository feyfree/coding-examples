package com.feyfree.design.visitor.demo2;

/**
 * 测试
 *
 * @author feyfree
 */
public class Client {
    public static void main(String[] args) {
        EmployeeGroup group = new EmployeeGroup();
        group.addEmployee(FullTimeEmployee.builder().name("陈咬金1").weeklyWage(10.0).workTime(1).build());
        group.addEmployee(FullTimeEmployee.builder().name("陈咬金2").weeklyWage(10.0).workTime(2).build());
        group.addEmployee(PartTimeEmployee.builder().name("陈咬金3").weeklyWage(10.0).workTime(3).build());
        group.addEmployee(PartTimeEmployee.builder().name("亚瑟1").weeklyWage(15.0).workTime(1).build());
        group.addEmployee(PartTimeEmployee.builder().name("亚瑟2").weeklyWage(20.0).workTime(1).build());
        group.addEmployee(PartTimeEmployee.builder().name("亚瑟3").weeklyWage(30.0).workTime(1).build());

        group.accept(new FinanceDepartment());
    }
}
