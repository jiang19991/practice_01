package com.company.se;

import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int sum = 0;
        scan.close();
        if (n<=1)
            System.out.println("请输入大于1的正整数");

        else{
            for (int i = 1; i <=n ; i++) {
                if ((i&1)==0)
                {
                    continue;
                }
                sum = sum+i;
            }
            System.out.println(sum);

        }
    }
}
