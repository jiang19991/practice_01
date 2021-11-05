package com.company.Test;

import java.util.*;

/**
 * @author 姜柏宇
 * 题目七
 */
public class test7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整数k（随机数的范围）、整数n(生成随机数的个数):");
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        Solution(k,n);
        scanner.close();
    }
    public  static void Solution(int k,int n){
        int[] arr = new int[n];
        for (int i = 0; i < n ; i++) {
            arr[i] = (int) (Math.random()*k);
        }
        System.out.print("原数组为：");
        System.out.println(Arrays.toString(arr));
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        int count = 0;
        //map保存每个数及该数对应的出现次数
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])){
                count = map.get(arr[i]);
                map.put(arr[i],++count);
            }else {
                map.put(arr[i],1);
            }
        }
        System.out.print("原map：");
        System.out.println(map.toString());
        //对map以value进行降序排序
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        System.out.println("排序后：");
        for (Map.Entry<Integer,Integer> mapping : list){
            System.out.println(mapping.getKey()+"  出现次数为： "+mapping.getValue());
        }

    }
}
