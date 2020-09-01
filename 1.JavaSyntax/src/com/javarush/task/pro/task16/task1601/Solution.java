package com.javarush.task.pro.task16.task1601;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Solution {

    static Date birthDate = new Date(86, 8, 3);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));
    }

    static String getDayOfWeek(Date date) {
        //напишите тут ваш код
        SimpleDateFormat format = new SimpleDateFormat("u", Locale.getDefault());
        return switch (Integer.parseInt(format.format(date))) {
            case 7 -> "воскресенье";
            case 1 -> "понедельник";
            case 2 -> "вторник";
            case 3 -> "среда";
            case 4 -> "четверг";
            case 5 -> "пятница";
            case 6 -> "суббота";
            default -> throw new IllegalStateException("Unexpected value: " + date.getDate());
        };
      /*  SimpleDateFormat format = new SimpleDateFormat("EEEE", Locale.getDefault());
        System.out.println(date.getDate());
        return format.format(date);*/
    }
}
