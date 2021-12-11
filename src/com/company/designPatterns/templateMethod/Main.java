package com.company.designPatterns.templateMethod;

/**
 * 模板方法模式
 */
public class Main {
    public static void main(String[] args) {
        F f = new C1();
        f.m();
    }
}

abstract class F{
    void m(){
        m1();
        m2();
    }
    abstract void m1();
    abstract void m2();
}

class C1 extends F {


    @Override
    void m1() {
        System.out.println("实现了m1方法");
    }

    @Override
    void m2() {
        System.out.println("实现了m2方法");
    }
}
