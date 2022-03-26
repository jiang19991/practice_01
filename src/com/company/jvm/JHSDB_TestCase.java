package com.company.jvm;

/**
 * @Description
 * @Author Jiang
 * @Date 2022/03/15 21:28
 * @Version 1.0.0
 */

public class JHSDB_TestCase {
    static class Test{
        static ObjectHolder staticObj = new ObjectHolder();
        ObjectHolder instanceObj = new ObjectHolder();

        void foo(){
            ObjectHolder localObj = new ObjectHolder();
            System.out.println("done");
        }
    }
    private static class ObjectHolder{}

    public static void main(String[] args) {
        Test test = new JHSDB_TestCase.Test();
        test.foo();


        System.out.println(111);



        System.out.println(333);
    }
}
