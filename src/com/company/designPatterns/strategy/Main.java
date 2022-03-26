package com.company.designPatterns.strategy;

import java.util.Arrays;

/**
 * 策略模式
 * sort方法不用变，根据不同的情况，传入不同的比较策略
 */
public class Main {

    public static void main(String[] args) {
        Sorter<Cat> sorter = new Sorter<>();
        Cat[] cats = {new Cat(5, 5), new Cat(2, 2), new Cat(6, 6)};
        //猫按照身高降序排序
        //匿名内部类写法
//        sorter.sort(cats, new Comparator<Cat>() {
//            @Override
//            public int compare(Cat t1, Cat t2) {
//                if (t1.height< t2.height) return 1;
//                else if(t1.height> t2.height) return -1;
//                else return 0;
//            }
//        });
        //lambda 表达式，函数式接口
        sorter.sort(cats, (o1, o2) -> {
            if (o1.height < o2.height) return 1;
            else if (o1.height > o2.height) return -1;
            return 0;
        });
        System.out.println(Arrays.toString(cats));


        Sorter<Dog> sorter1 = new Sorter<>();
        Dog[] dogs = {new Dog(5), new Dog(2), new Dog(6)};
        //狗按照食物升序排序
        //匿名内部类写法
//        sorter1.sort(dogs, new Comparator<Dog>() {
//            @Override
//            public int compare(Dog t1, Dog t2) {
//                if (t1.food < t2.food) return -1;
//                else if (t1.food > t2.food) return 1;
//                else
//                    return 0;
//            }
//        });

        //Lambda 表达式写法
        sorter1.sort(dogs, (t1, t2) -> {
            if (t1.food < t2.food) return -1;
            else if (t1.food > t2.food) return 1;
            return 0;
        });
        System.out.println(Arrays.toString(dogs));

    }

}
