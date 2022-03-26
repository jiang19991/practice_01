package com.company.designPatterns.factory.factorymethod;

/**
 * 简单工厂
 */
public class CarFactory {
    public Moveable create(){
        System.out.println("a car was created");
        return new Car();
    }

}
