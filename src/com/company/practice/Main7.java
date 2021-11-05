package com.company.practice;

import java.util.ArrayList;

public class Main7 {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        ArrayList<String> list = new ArrayList<>();
        list.add("abc");
        System.out.println(list.get(0).toUpperCase());
        ArrayList lit2 = list;
        System.out.println(list.get(0).toString());
    }
}
