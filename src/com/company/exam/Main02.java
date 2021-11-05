package com.company.exam;

import javax.swing.*;
import java.util.Arrays;


public class Main02 {
    public static void main(String[] args) {
        testBit();
    }
    private static Integer cnt =0;
    private static void func(int...numbers){
        for (int n : numbers) {
            if (n % 2 == 1){
                System.out.print(n>>1);
            }else
                System.out.print(cnt++);
        }
    }

    private static void testBit(){
        int n=3;
        int[] numbers = new int[n<<1];
        int k=0;
        for (int i = -n; i < n; i++) {
            numbers[k++] = i;
        }
        System.out.println(Arrays.toString(numbers));
        func(numbers);
    }
}
