package com.company.designPatterns.factory.abstractfactory;

/**
 * 抽象工厂模式，在 产品一族 的扩展上比较容易
 */
public class Main {
    public static void main(String[] args) {


//        Car car = new Car();
//        car.go();
//        AK47 a = new AK47();
//        a.shoot();
//        Bread b = new Bread();
//        b.printName();

        AbstractFactory f = new ModernFactory();

        Vehicle c = f.createVehicle();
        c.go();
        Weapon w = f.createWeapon();
        w.shoot();
        Food b = f.createFood();
        b.printName();


    }

}
