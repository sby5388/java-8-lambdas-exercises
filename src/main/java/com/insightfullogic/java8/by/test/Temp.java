package com.insightfullogic.java8.by.test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * @author by5388  on 2019/3/5.
 */

class Temp {

    //把可以迭代的数据转换成流！！stream
    static void test(List<String> strings) {
        Stream<String> stream = strings.stream();
    }

    static void test(Set<String> strings) {
        Stream<String> stream = strings.stream();
    }


    static void test(String... strings) {
        Stream<String> stream = Arrays.stream(strings);
    }

    //同上
    static void test2(String[] strings) {
        Stream<String> stream = Arrays.stream(strings);
    }
}
