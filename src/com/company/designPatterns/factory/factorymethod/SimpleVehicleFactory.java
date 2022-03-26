package com.company.designPatterns.factory.factorymethod;

/**
 * 简单工厂的可扩展性不好
 */
public class SimpleVehicleFactory {

    public Car createCar(){
        //before processing

        return new Car();
    }

    public Broom createBroom() {
        //before processing

        return new Broom();
    }

    public Plane createPlane() {
        //before processing

        return new Plane();
    }
}
