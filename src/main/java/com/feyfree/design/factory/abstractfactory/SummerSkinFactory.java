package com.feyfree.design.factory.abstractfactory;

/**
 * 具体工厂
 *
 * @author leilei
 */
public class SummerSkinFactory implements ISkinFactory {
    /**
     * 创建方法
     *
     * @return button
     */
    @Override
    public IButton createButton() {
        return new SummerButton();
    }

    /**
     * 创建方法
     *
     * @return text field
     */
    @Override
    public ITextField createTextField() {
        return new SummerTextField();
    }

    /**
     * 创建方法
     *
     * @return combo box
     */
    @Override
    public IComboBox createComboBox() {
        return new SummerComboBox();
    }
}
