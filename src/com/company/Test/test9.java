package com.company.Test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author 姜柏宇
 * 题目9
 */
public class test9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入整数n:");
        int n = scanner.nextInt();
        int [][] mat = ProduceMatrix(n);

        Print(mat);
        scanner.close();
    }

    public static int[][] ProduceMatrix(int n) {
        int[][] matrix = new int[n][n];
        int a = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = a++;
            }
        }
        System.out.println("原数组：");
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
        return matrix;
    }

    public static void Print(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ArrayList<Integer> list = new ArrayList<>();
        int rowbegin = 0,//行开始
                rowend = m - 1,//行结束
                colbegin = 0,//列开始
                colend = n - 1;//列结束
        while(rowbegin<=rowend&&colbegin<=colend){
            //左->右
            for (int i = colbegin;i<=colend;i++){
                list.add(matrix[rowbegin][i]);
            }
            rowbegin++;
            //上->下
            for (int j = rowbegin; j <= rowend ; j++) {
                list.add(matrix[j][colend]);
            }
            colend--;
            //右->左
            if (rowbegin<=rowend){
                for (int i = colend; i >= colbegin ; i--) {
                    list.add(matrix[rowend][i]);
                }
            }
            rowend--;
            //下->上
            if (colbegin<=colend){
                for (int i = rowend; i >= rowbegin ; i--) {
                    list.add(matrix[i][colbegin]);
                }
            }
            colbegin++;
        }
        System.out.println("遍历结果：");
        System.out.println(list.toString());
    }
}
