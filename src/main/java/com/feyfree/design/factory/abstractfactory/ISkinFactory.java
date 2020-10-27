package com.feyfree.design.factory.abstractfactory;

/**
 * 抽象工厂
 *
 * @author leilei
 */
public interface ISkinFactory {

    /**
     * 创建方法
     *
     * @return button
     */
    IButton createButton();

    /**
     * 创建方法
     *
     * @return text field
     */
    ITextField createTextField();

    /**
     * 创建方法
     *
     * @return combo box
     */
    IComboBox createComboBox();
}
