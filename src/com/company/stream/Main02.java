package com.company.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream中间操作
 */
public class Main02 {
    public static void main(String[] args) {
        String str = "bu,gao,xing,jiu,he,shui";

        //转成list集合
        //输出集合
        Stream.of(str.split(",")).collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println();

        //拿到长度大于2的单词
        Stream.of(str.split(",")).filter(s -> s.length() > 2)
                .forEach(System.out::println);

        //flatMap的使用，可以拿到str中所有的字母
        Stream.of(str.split(",")).flatMap(s -> s.chars().boxed())
                .forEach(i -> System.out.println((char) i.intValue()));

        System.out.println();

        //filter用来过滤符合条件的元素，peek可以输出流操作中的中间值，主要用来调试代码用
        Stream.of(str.split(",")).filter(e -> e.length() > 3)
                .peek(e -> System.out.println("过滤出来的元素： " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("映射过后的元素： " + e))
                .collect(Collectors.toList());
    }
}
