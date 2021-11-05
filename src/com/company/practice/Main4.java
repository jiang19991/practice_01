package com.company.practice;

public class Main4 {
    public static void main(String[] args) {
        int []array = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};

        sort(array);
        print(array);
    }
    //希尔排序

    static void sort(int []array)
    {
        //int gap = 4;
        int count = 0;
//        int h=1;
//        while (h<array.length/3)
//        {
//            h = h*3+1;
//        }
        for (int gap = array.length/2;gap>0;gap=gap/2){
            for (int i = gap;i<array.length;i++)
            {
                for (int j=i;j>gap-1;j-=gap)
                {
                    if (array[j]<array[j-gap])
                    {
                        swap(array,j,j-gap);
                        count++;
                    }
                    print(array);
                    System.out.println();
                }
            }
        }
        System.out.println(count);

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
