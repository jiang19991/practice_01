package com.company.exam;

import java.util.Arrays;
import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = input.nextInt();
        }
//        System.out.println(Arrays.toString(arr));
        int res = solution(num, arr);
        System.out.println(res);

    }

    public static int solution(int num, int[] arr) {
        int res = 1;
        if (num == 1) {
            return res;
        }
        Arrays.sort(arr);
        /**
         * 6
         * 1 2 3 5 6 7
         * 4
         */
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++){
                if (Math.abs(arr[j] - arr[i])>1){
                    res++;
                    i = j-1;
                    break;
                }else {
                    continue;
                }
            }
        }
        return res;
    }
}
