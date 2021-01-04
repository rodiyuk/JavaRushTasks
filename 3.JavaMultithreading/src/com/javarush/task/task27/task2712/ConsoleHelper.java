package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
        writeMessage(Arrays.asList(Dish.values()).toString());
        writeMessage("Список блюд:");
        writeMessage(Dish.allDishesToString());
        writeMessage("Введине выбранное блюдо:");
        while (true) {
            String dish = readString();
            if (dish.equals("exit")) break;
            Dish choose = Dish.valueOf(dish);
            if (!Arrays.asList(Dish.values()).contains(Dish.valueOf(dish)))
                writeMessage("Данного блюда нет в продаже");
            else dishes.add(Dish.valueOf(dish));
        }
        return dishes;
    }
}
