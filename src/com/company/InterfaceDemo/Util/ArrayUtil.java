package com.company.InterfaceDemo.Util;
//命令模式
public class ArrayUtil {
    //冒泡排序
    public static void sort(int [] array,Comparator cpr){
        for (int i = 0;i< array.length;i++){
            for (int j = 0;j<array.length-1-i;j++){
                //普通模式排序
//                if (array[j]>array[j+1]){
//                    int temp = array[j];
//                    array[j] = array[j+1];
//                    array[j+1] = temp;
//                }
                //命令模式
                if (cpr.compare(array[j],array[j+1])>0){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }


}
