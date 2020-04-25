package com.feyfree.others;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestMoneySplit {


    @Test
    public void testSplit() {
        double[] cases = {100.59, 120.16, 230.70, 288.80,
                323.24, 67.82, 96.53, 51.13,
                60.00, 53.64, 12.05, 18.09,
                30.52, 10, 50, 100, 0};
        for (double aCase : cases) {
            List<BigDecimal> testArray = new ArrayList<>(10);
            System.out.println("====================start-split================");
            System.out.println("value: " + aCase);
            printArray(split(BigDecimal.valueOf(aCase), testArray));
            System.out.println("********************end-split==================");
        }
    }

    public List<BigDecimal> split(BigDecimal amount, List<BigDecimal> moneyArray) {
        if (amount.doubleValue() <= 0) {
            return moneyArray;
        }
        if (amount.doubleValue() >= 100) {
            moneyArray.add(BigDecimal.valueOf(100L));
            split(amount.subtract(BigDecimal.valueOf(100L)), moneyArray);
        } else if (amount.doubleValue() >= 50 && amount.doubleValue() < 100) {
            moneyArray.add(BigDecimal.valueOf(50L));
            split(amount.subtract(BigDecimal.valueOf(50L)), moneyArray);
        } else if (amount.doubleValue() >= 10 && amount.doubleValue() < 50) {
            moneyArray.add(BigDecimal.valueOf(10L));
            split(amount.subtract(BigDecimal.valueOf(10L)), moneyArray);
        } else if (amount.doubleValue() > 0 && amount.doubleValue() < 10) {
            moneyArray.add(amount);
            amount = BigDecimal.ZERO;
            split(amount, moneyArray);
        }
        return moneyArray;
    }

    public void printArray(List<BigDecimal> testArray) {
        testArray.forEach(System.out::println);
    }


}
