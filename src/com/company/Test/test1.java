package com.company.Test;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 姜柏宇
 * 题目1
 */
public class test1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个正整数：");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = sum + array[j];
                list.add(array[j]);
                if (sum == n) {
                    System.out.println(list.toString());
                    list.clear();
                    sum = 0;
                    break;
                }
                if (sum > n) {
                    sum = 0;
                    list.clear();
                    break;
                }
            }
        }
        scanner.close();
    }
}
