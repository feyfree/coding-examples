package com.feyfree.design.visitor.demo2;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工集合
 *
 * @author leilei
 */
@Data
public class EmployeeGroup {

    private List<IEmployee> employees = new ArrayList<>();


    public void addEmployee(IEmployee employee) {
        employees.add(employee);
    }

    public void accept(Department department) {
        for (IEmployee employee : employees) {
            employee.accept(department);
        }
    }
}
