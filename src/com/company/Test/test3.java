package com.company.Test;

/**
 * @author 姜柏宇
 * 题目三
 */
public class test3 {
    public static void main(String[] args) {
        int a=0,b=0,c=0,d=0;
        for (int i = 30;i<100;i++){
            int m = i*i;
            int temp = m;
            a = m %10;
            m /=10;
            b = m%10;
            m /=10;
            c = m%10;
            m /=10;
            d = m%10;

            if(a==b&&c==d&&b!=c){
                System.out.println(temp);
                //System.out.println(Math.sqrt(temp));
            }

        }
    }
}
