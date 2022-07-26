package com.feyfree.basic.map;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * map 和 flatmap 示例
 *
 * @author leilei
 */
public class MapAndFlatmapDemo {
    public static void main(String[] args) {
        List<String> myList = Stream.of("a", "b")
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(myList);

        List<List<String>> list = Arrays.asList(
                Collections.singletonList("a"),
                Collections.singletonList("b"));
        System.out.println(list);

        System.out.println(list
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList()));

        List<List<List<String>>> nested = Arrays.asList(
                Collections.singletonList(Collections.singletonList("a")),
                Collections.singletonList(Collections.singletonList("b")));

        System.out.println(nested
                .stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList())); // [[a], [b]]

        System.out.println(nested
                .stream()
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())); // [a, b]


    }
}
