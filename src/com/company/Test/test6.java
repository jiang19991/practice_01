package com.company.Test;

import java.util.Map;
import java.util.Scanner;

/**
 * @author 姜柏宇
 * 题目六
 */
public class test6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一字符串：");
        String str = scanner.nextLine();
        MaxLen(str);
        scanner.close();
    }

    public static void MaxLen(String str) {
        if (str == "")
            return;
        int count = 0;
        int j = 0;
        int max = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                count++;//记录数字字符串的长度
                if (count > max) {
                    max = count;//保存最大的count
                    j = i - count + 1;//j保存数字字符串的起始下标
                }
            } else {
                count = 0;
            }
        }
        System.out.println(str.substring(j, max + j));
    }
}
