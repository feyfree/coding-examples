package com.feyfree.basic.functional.demo3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // 将Stream转换成容器或Map
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        List<String> list = stream.collect(Collectors.toList());
        Set<String> set = stream.collect(Collectors.toSet());
        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));
        // 指定底层类型
        stream.collect(Collectors.toCollection(ArrayList::new));
    }
}
