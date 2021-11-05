package com.company.practice;

public class Main3 {
    //插入排序
    public static void main(String[] args) {
        int []array = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};//69135 61935 16935
        int count = 0;
        for (int i=1;i<array.length;i++){
            for (int j=i;j>0;j--)
            {
                if (array[j]<array[j-1]){
                    swap(array,j,j-1);
                    count++;
                }
            }
            System.out.print("第"+i+"次循环后的结果：");
            print(array);
            System.out.println();
        }
        print(array);
        System.out.print(count);
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
