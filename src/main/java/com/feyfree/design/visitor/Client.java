package com.feyfree.design.visitor;

public class Client {
    static public void main(String[] args) {
        Car car = new Car();
        car.addVisit(new Body());
        car.addVisit(new Engine());
        Visitor print = new PrintCar();
        car.show(print);
    }
}