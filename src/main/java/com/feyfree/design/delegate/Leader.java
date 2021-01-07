package com.feyfree.design.delegate;

import java.util.HashMap;
import java.util.Map;

public class Leader implements IEmployee {
    private Map<String, IEmployee> targets = new HashMap<>();

    public Leader() {
        targets.put("driving", new EmployeeA());
        targets.put("cleaning", new EmployeeB());
    }

    @Override
    public void doing(String command) {
        targets.get(command).doing(command);
    }
}
