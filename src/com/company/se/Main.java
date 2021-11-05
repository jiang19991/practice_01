package com.company.se;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int p = scan.nextInt();
        int q = scan.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
      int result = solu(n,p,q,array);
        System.out.println(result);
    }
    public static void sort(int[] array){
        for(int i=0;i<array.length;i++)
        {
            int MinPos = i;
            for(int j = i+1;j<array.length;j++)
            {
                if (array[j]>array[MinPos]){
                    MinPos = j;
                }
            }
            swap(array,i,MinPos);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] =array[j];
        array[j] = temp;
    }

    private static int  solu(int n, int p, int q, int[] array) {
        if(n==0||array.length==0)
            return 0;
        sort(array);
        int count = 0;
        int temp=100;
        for (int i = 0; i < n; i++) {
            if (array[i]*q/100+temp*p/100>=60){
                count++;
                if(i!=n-1){
                    if (array[i]>array[i+1]){
                        temp--;
                    }else
                        temp =temp;
                }
            }
        }
        return count;
    }
}
