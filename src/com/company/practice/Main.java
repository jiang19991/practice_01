package com.company.practice;


import org.junit.jupiter.api.Test;

public class Main {
//筛选素数(埃氏筛法),求n以内的素数，不包括n
    public static void main(String[] args) {
	// write your code here
        int N = 101;
        boolean [] pre = new boolean[N];//先用false标记所有的数都是素数
        for(int i=2;i*i<N;i++)
        {
            if(!pre[i]){//如果i是素数
                for(int j = i * i;j<N;j+=i){//将j从i的平方开始，每次加上i的数都标记为非素数
                    pre[j] = true;//j标记为非素数
                }
            }
        }
//        int [] array = new int [N];
//        int tot = 0;
//        for (int m = 1;m<pre.length;m++)
//        {
//            if (!pre[m])
//                array[tot++] = m;
//        }
        int count = 0;
        for (int i = 2;i<N;i++)
        {
                if (!pre[i])
                {
                    System.out.print(i+"\t");
                    count++;
                }
                if(count%10==0)
                    System.out.println();

        }
    }
}
class test{
    public static void main(String[] args) {

    }
    @Test
    public static void ttttt1(){
        int x =0;
        int y =10;
        do {
            y--;
            x++;
        }while (x<5);
        System.out.println(x);
        System.out.println(y);
    }
}
