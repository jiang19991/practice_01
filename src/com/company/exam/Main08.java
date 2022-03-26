package com.company.exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author Jiang
 * @Date 2022/03/05 10:48
 * @Version 1.0.0
 */

public class Main08 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
//        System.out.println(n+" "+m);
        String[] chars = new String[m];
        for (int i = 0; i < m; i++) {
            chars[i] = input.next();
        }
//        System.out.println(Arrays.toString(chars));
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = input.nextInt();
        }

//       int[] res =  solu(n,m,chars,array);
    }

//    private static int[] solu(int n, int m,String[] chars, int[] array) {
//        int v = n*n*n;
//        int[] ans = new int[m];
//        int temp = v;
//        for (int i = 0; i < m; i++) {
//            switch (chars[i]){
//                case("x") :
//                    int tempV = array[i]*n;
//                    break;
//                case("y"):
//                    break;
//                case("z"):
//                    break;
//                    continue;
//            }
//        }
//
//    }

}
