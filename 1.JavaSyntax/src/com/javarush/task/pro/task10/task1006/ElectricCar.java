package com.javarush.task.pro.task10.task1006;

/* 
Кто тут наследник?
*/
public class ElectricCar extends Car {

    public ElectricCar() {
        super("ElectricCar");
    }

    public static void main(String[] args) {
        //напишите тут ваш код
        ElectricCar electricCar = new ElectricCar();
        GasCar gasCar = new GasCar();
        HybridCar hybridCar = new HybridCar();
    }
 }