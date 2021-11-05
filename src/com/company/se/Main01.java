package com.company.se;

import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] array = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                array[i][j] = scan.nextInt();
            }
        }
        boolean flag = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(array[i][j]!=array[2-i][2-j]){
                    System.out.println("NO");
                    flag=false;
                    break;
                }
            }
        }
        if (flag==true)
            System.out.println("YES");
    }
}
