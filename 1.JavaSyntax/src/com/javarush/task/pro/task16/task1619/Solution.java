package com.javarush.task.pro.task16.task1619;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Solution {

    static LocalDateTime localDateTime = LocalDateTime.now();

    public static void main(String[] args) {
        //напишите тут ваш код   19.03.2020г. 5ч.4мин
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyyг. HHч.mmмин");
        System.out.println(dtf.format(localDateTime));
    }
}
