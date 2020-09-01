package com.javarush.task.pro.task16.task1607;

import java.time.LocalDate;
import java.time.Month;

public class Solution {
    public static LocalDate date = LocalDate.of(2020, 9, 12);
    public static void main(String[] args) {
        System.out.println(nowExample());
        System.out.println(ofExample());
        System.out.println(ofYearDayExample());
        System.out.println(ofEpochDayExample());
    }

    static LocalDate nowExample() {
        //напишите тут ваш код
        return LocalDate.now();
    }

    static LocalDate ofExample() {
        //напишите тут ваш код
        return LocalDate.of(2020, Month.SEPTEMBER, 12);
    }

    static LocalDate ofYearDayExample() {
        //напишите тут ваш код
        int yearOfDay = date.getDayOfYear();
        return LocalDate.ofYearDay(2020, yearOfDay);
    }

    static LocalDate ofEpochDayExample() {
        //напишите тут ваш код
        long days = date.toEpochDay();
        return LocalDate.ofEpochDay(days);
    }
}
