package com.company.practice;

import org.junit.Test;

public class test333 {
    public static void main(String[] args) {
        AAA a = new AAA();
        BBB b = new BBB();
        CCC c = new CCC();
        a.test(a);
        a.test(b);
        a.test(c);
        b.test(a);
        b.test(b);
        b.test(c);
        c.test(a);
        c.test(b);
        c.test(c);
    }
}

class AAA{
    public void test(AAA a){
        System.out.println("A");
    }
}
class BBB extends AAA{
    public void test(AAA a){
        System.out.println("BA");
    }
    public void test(BBB b){
        System.out.println("BB");
    }
}
class CCC extends BBB{
    public void test(AAA a){
        System.out.println("CA");
    }
    public void test(BBB b){
        System.out.println("CB");
    }
    public void test(CCC c){
        System.out.println("CC");
    }
}

class main11{
    public static void main(String[] args) {
        String abc = new String("abc");
        char[] arr = {'d','e','f'};
        Integer i1 = 10;
        int i2 = 100;
        Integer i3 = 1000;
        change(abc,arr,i1,i2,i3);
        System.out.println(i1+" "+i2+" "+i3+" "+abc+" "+new String(arr));
        System.out.println(i1+i2+i3+abc+new String(arr));
        int x =20;
        int y=5;
        System.out.println(" "+(x+y)+y);
        System.out.println(x+y+" "+(x+y)+y);


        System.out.println(true?false:true);
        System.out.println(true?false:true == true?false:true);
        System.out.println(false==false);
    }

    private static void change(String abc, char[] arr, Integer i1, int i2, Integer i3) {
        abc = "ABC";
        arr[1] = 'E';
        i1 = 20;
        i2 = 200;
        i3 = 2000;
    }
}
