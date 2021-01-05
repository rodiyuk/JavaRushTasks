package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        String text = bis.readLine();
        return text;
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> dishes = new ArrayList<>();
        writeMessage("Список блюд:");
        writeMessage(Dish.allDishesToString());
        writeMessage("Выберите блюдо:");
        while (true) {
            String dish = readString();
            if (dish.equals("exit")) break;
            if (!contains(dish))
                writeMessage("Данного блюда нет в продаже");
            else dishes.add(Dish.valueOf(dish.toUpperCase()));
        }
        return dishes;
    }

    public static boolean contains(String test) {
        for (Dish d : Dish.values()) {
            if (d.name().toLowerCase().equalsIgnoreCase(test)) {
                return true;
            }
        }
        return false;
    }
}
