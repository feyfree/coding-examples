package com.feyfree.design.factory.abstractfactory;

/**
 * 具体工厂
 *
 * @author leilei
 */
public class SpringSkinFactory implements ISkinFactory {
    /**
     * 创建方法
     *
     * @return button
     */
    @Override
    public IButton createButton() {
        return new SpringButton();
    }

    /**
     * 创建方法
     *
     * @return text field
     */
    @Override
    public ITextField createTextField() {
        return new SpringTextField();
    }

    /**
     * 创建方法
     *
     * @return combo box
     */
    @Override
    public IComboBox createComboBox() {
        return new SpringComboBox();
    }
}
