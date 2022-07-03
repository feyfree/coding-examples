package com.feyfree.basic.beans;

import java.beans.*;
import java.util.stream.Stream;

public class BeanDemo {
    public static void main(String[] args) throws IntrospectionException {

        // Object.class 是 stopClass 因为 Object 是任何类的父类, 如果不加 stopClass 还会因为getClass 的method 打印一个class 的信息
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> {
            Class<?> propertyType = propertyDescriptor.getPropertyType();
            String propertyDescriptorName = propertyDescriptor.getName();
            if ("age".equals(propertyDescriptorName)) {
                propertyDescriptor.setPropertyEditorClass(String2IntegerEditor.class);
            }
        });
    }


    static class String2IntegerEditor extends PropertyEditorSupport {
        @Override
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }

    }
}
