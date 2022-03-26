package com.company.designPatterns.factory.factorymethod;

/**
 * 工厂方法，在产品维度上扩展比较容易
 */
public class Main {
    public static void main(String[] args) {
        Moveable m = new CarFactory().create();
        m.go();


    }

}
