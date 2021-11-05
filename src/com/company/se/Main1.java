package com.company.se;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int x = scan.nextInt();
        int k = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        int res = solu(n,m,x,k,array);
    }
        public static int solu(int n,int m,int x,int k, int[] array){
            int res =0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {

                }
            }
            return 0;
        }

}
