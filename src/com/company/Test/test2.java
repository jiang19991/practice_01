package com.company.Test;

import java.util.Scanner;

/**
 * @author 姜柏宇
 * <p>
 * 题目二. 判断回文
 */
public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int n = scanner.nextInt();
        isReverse(n);
        scanner.close();
    }

    public static void isReverse(int n) {

        int m = 0;
        int t = n;
        while (n >= 1) {
            int temp = n % 10;
            m = m * 10 + temp;
            n = n / 10;
        }
        if (t == m)
            System.out.println(true);

        else
            System.out.println(false);

    }

}
