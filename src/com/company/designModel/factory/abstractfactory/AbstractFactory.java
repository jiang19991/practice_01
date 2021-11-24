package com.company.designModel.factory.abstractfactory;

/**
 * 抽象工厂
 */
public abstract class AbstractFactory {
    abstract Food createFood();
    abstract Weapon createWeapon();
    abstract Vehicle createVehicle();
}
