package com.company.se;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        int count = 0;
        int sum = 0;
        n = scanner.nextInt();
        while (n>=0)
        {
            count++;
            sum = sum +n;
            n = scanner.nextInt();
        }
            double ave = (double)sum/count;
            System.out.println(ave);
        scanner.close();
    }
}
