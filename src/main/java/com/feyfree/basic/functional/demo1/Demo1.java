package com.feyfree.basic.functional.demo1;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class Demo1 {
    public static void main(String[] args) {
        ConsumerInterface<String> consumer = str -> System.out.println(str);
        MyStream<String> stream = new MyStream<>();
        stream.setList(Arrays.asList("1", "2", "3"));
        stream.myForEach(consumer);
    }
}

@Data
class MyStream<T> {
    private List<T> list;

    public void myForEach(ConsumerInterface<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
