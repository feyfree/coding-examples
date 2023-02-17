package com.feyfree.basic.functional.demo1;

@FunctionalInterface
public interface ConsumerInterface<T> {
    void accept(T t);
}
