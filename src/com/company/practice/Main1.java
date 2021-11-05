package com.company.practice;
import java.awt.desktop.SystemEventListener;
import java.net.SocketOption;
import java.sql.SQLOutput;
import java.util.*;
public class Main1 {
    //选择排序
    public static void main(String[] args) {
        int [] array = {2,3,4,6,7,9,0,1,5,8};
        print(array);
        for(int i=0;i<array.length;i++)
        {
            int MinPos = i;
            for(int j = i+1;j<array.length;j++)
            {
                if (array[j]<array[MinPos]){
                    MinPos = j;
                }
            }
            System.out.println("最小值位于：" + MinPos);
            swap(array,i,MinPos);
            System.out.println("经过第"+i+"次循环：");
            print(array);
        }
        print(array);

    }
    static void print(int [] array)
    {
        for (int i=0;i<array.length;i++)
        {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    static void swap(int [] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
