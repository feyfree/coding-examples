package com.feyfree.design.visitor.demo2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 全职员工
 *
 * @author feyfree
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FullTimeEmployee implements IEmployee {

    private String name;
    private double weeklyWage;
    private int workTime;


    @Override
    public void accept(Department handler) {
        handler.visit(this);
    }
}
