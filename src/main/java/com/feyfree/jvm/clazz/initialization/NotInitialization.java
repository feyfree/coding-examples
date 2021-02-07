package com.feyfree.jvm.clazz.initialization;

/**
 * 对于静态字段， 只有直接定义这个字段的类才会被初始化
 * 因此通过其子类来引用父类中定义的静态字段，只会触发父类的初始化，而不会
 * 触发子类的初始化
 *
 * @author leilei
 */
public class NotInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
