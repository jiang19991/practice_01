package com.company.codeTop;

import org.junit.Test;

public class PracGuPiao {
    public static void main(String[] args) {
        int[] array = {7,1,5,3,6,4};
        String s1 = "a";
        String s2 = s1 + "b";
        System.out.println(s2 == "ab");
//        findMaxProfix(array);
    }
    public static void findMaxProfix(int[] array){
        if(array==null)
            return;
        int n = array.length;
        int[] dp = new int[n];
        dp[0] = 0;
        int curmin = array[0];
        int max = 0;
        for (int i = 1; i < n; i++) {
            if(array[i]<curmin)
                curmin = array[i];
            max = Math.max(max,array[i]-curmin);
        }
        System.out.println(max);
    }
    @Test
    public static void test(){

    }
}
class Singleton{
    private static volatile Singleton singleton =null;
    private Singleton(){}
    public Singleton getSingleton(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}