package com.company.exam;

import java.util.Scanner;

public class Main06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                array[i][j] = scanner.nextInt();
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(array[i][j]+" ");
//            }
//        }
        int[][] dp = new int[n][n];
        dp[0][0] = array[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + array[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i; j++) {
                if (array[i + 1][j] == 0 || array[i][j + 1] == 0)
                    break;
                dp[i][j] = dp[i - 1][j - 1] + Math.min(array[i + 1][j], array[i][j + 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        System.out.println(ans);
    }
}
/*
 * 2 0 0
 * 4 5 0
 * 1 2 3
 *
 * 2 0 0
 * 6 9 0
 * 7 8 11
 *
 * */