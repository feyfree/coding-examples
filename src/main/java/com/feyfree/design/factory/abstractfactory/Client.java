package com.feyfree.design.factory.abstractfactory;

public class Client {
    public static void main(String[] args) {
        // 可以基于反射找到工厂类 这里先手写
        SpringSkinFactory skinFactory = new SpringSkinFactory();
        IButton springButton = skinFactory.createButton();
        springButton.display();
        IComboBox comboBox = skinFactory.createComboBox();
        comboBox.display();
        ITextField textField = skinFactory.createTextField();
        textField.display();
    }
}
