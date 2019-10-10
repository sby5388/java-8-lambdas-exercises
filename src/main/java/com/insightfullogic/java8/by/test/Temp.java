package com.insightfullogic.java8.by.test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
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

    //断言:返回的是一个boolean值
    private Predicate<Integer> mBigThan10 = x -> (x > 10);
    private Predicate<Integer> mBingThan20 = new Predicate<Integer>() {
        @Override
        public boolean test(Integer integer) {
            return integer > 20;
        }
    };

    // TODO: 2019/10/10 本质上就是一个带参数的Runnable接口
    private Consumer<Integer> mIntegerConsumer = new Consumer<Integer>() {
        @Override
        public void accept(Integer integer) {
            System.out.println("integer  = " + integer);
        }
    };


    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            System.out.println(Calendar.getInstance(Locale.CHINA).getTime());
        }
    };

    /**
     * 类似于rxJava链式调用中的类型转换接口
     */
    private Function<String, Integer> mWordLength = new Function<String, Integer>() {
        @Override
        public Integer apply(String s) {
            return s.length();
        }
    };


    //工厂模式？
    private Supplier<Integer> mIntegerSupplier = new Supplier<Integer>() {
        @Override
        public Integer get() {
            return 10;
        }
    };

    public static void main(String[] args) {
        Temp temp = new Temp();

        final int a = 10;
        final int b = 20;

        System.out.println(temp.mBigThan10.test(a));
        System.out.println(temp.mBigThan10.test(b));
        temp.mIntegerConsumer.accept(a);
        temp.mIntegerConsumer.accept(b);
        temp.mRunnable.run();

        final String keyA = "hello";
        final String keyB = "world!";

        System.out.println(temp.mWordLength.apply(keyA));
        System.out.println(temp.mWordLength.apply(keyB));

    }


}
