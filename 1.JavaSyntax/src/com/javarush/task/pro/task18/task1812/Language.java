package com.javarush.task.pro.task18.task1812;

public class Language {
    private String name;
    private Double rating;

    public Language(String name, Double rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public Double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Язык программирования - " + name + ", рейтинг  - " + rating + "% опрошенных.";
    }
}
