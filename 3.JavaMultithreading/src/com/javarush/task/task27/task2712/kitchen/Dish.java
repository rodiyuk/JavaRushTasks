package com.javarush.task.task27.task2712.kitchen;

public enum Dish {
    FISH,
    STEAK,
    SOUP,
    JUICE,
    WATER;

    public static String allDishesToString() {
        StringBuilder menu = new StringBuilder("");
        for (Dish dish : values()) {
            if (menu.toString().equals(""))
                menu.append(dish);
            else menu.append(", ").append(dish);
        }
        return menu.toString();
    }
}
