package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Waiter;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws IOException {
        Cook cook = new Cook("Amigo");
        Waiter waiter = new Waiter();
        cook.addObserver(waiter);
        Tablet tablet = new Tablet(5);
        tablet.addObserver(cook);
        
        tablet.createOrder();
/*
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
        tablet.createOrder();
*/
    }
}
