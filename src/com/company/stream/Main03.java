package com.company.stream;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream的终止操作
 */
public class Main03 {
    public static void main(String[] args) {
        String str = "bu gao xing jiu he shui ";

        //使用foreach得到乱序结果（因为使用了并行流）
        str.chars().parallel().forEach(i -> System.out.print((char) i));
        System.out.println();

        //使用forEachOrdered得到顺序结果
        str.chars().parallel().forEachOrdered(i -> System.out.print((char) i));
        System.out.println();

        //收集到list集合中
        List<String> list = Stream.of(str.split(" "))
                .collect(Collectors.toList());
        System.out.println(list);

        //使用reduce对字符串进行拼接
        Optional<String> stringOptional = Stream.of(str.split(" "))
                .reduce((s1, s2) -> s1 + "-" + s2);
        System.out.println(stringOptional.get());

        //计算有效的字符串总长度
        Integer length = Stream.of(str.split(" ")).map(s -> s.length())
                .reduce(0, (s1, s2) -> s1 + s2);
        System.out.println(length);

        //取最大长度的单词
        Optional<String> max = Stream.of(str.split(" "))
                .max((s1, s2) -> s1.length() - s2.length());
        System.out.println(max.get());

        //使用findFirst取第一个元素，取到则中断操作
        Optional<String> findFirst = list.stream().findFirst();
        System.out.println(findFirst.get());
    }
}
