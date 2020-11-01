package com.feyfree.design.builder.hierarchies;

import static com.feyfree.design.builder.hierarchies.NyPizza.Size.SMALL;
import static com.feyfree.design.builder.hierarchies.Pizza.Topping.*;

public class Demo {
    public static void main(String[] args) {
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE).addTopping(ONION).build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
    }
}
