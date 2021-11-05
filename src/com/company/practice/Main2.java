package com.company.practice;

public class Main2 {
    //冒泡排序
    public static void main(String[] args) {
        int []array = {9,2,6,3,4,1,8,5,7,0};
        for (int j = array.length-1;j>0;j--)
        {
            for (int i=0;i<j;i++)
            {
                if(array[i]>array[i+1])
                {
                    swap(array,i,i+1);
                }

            }
            print(array);
            System.out.println();
        }
        print(array);
    }

    static  void print(int array[])
    {
        for (int i=0;i<array.length;i++)
            System.out.print(array[i]+" ");
    }

     static void swap(int [] arr,int i,int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
