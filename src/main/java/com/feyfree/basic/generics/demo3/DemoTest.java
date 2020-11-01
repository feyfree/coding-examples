package com.feyfree.basic.generics.demo3;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Cat());
        animals.add(new Dog());
        animalsName(animals);
        animalsName1(animals);

        // -------------

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        animalsName(dogs);
        // 编译的时候就不过关
//        animalsName1(dogs);
    }

    public static void animalsName(List<? extends Animal> animals) {
        animals.forEach(Animal::myName);
    }

    public static void animalsName1(List<Animal> animals) {
        animals.forEach(Animal::myName);
    }
}
