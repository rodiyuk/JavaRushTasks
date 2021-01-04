package com.javarush.task.task27.task2712;

import java.io.IOException;

public class Restaurant {
    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.createOrder();
        }
    }
}
