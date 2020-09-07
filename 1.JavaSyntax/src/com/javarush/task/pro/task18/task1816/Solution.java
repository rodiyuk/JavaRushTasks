package com.javarush.task.pro.task18.task1816;

import java.util.stream.Stream;

/* 
Преобразование данных
*/

public class Solution {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Программирование", "Это", "Как", "Бить", "Себя", "По", "Лицу",
                "Рано", "Или", "Поздно", "Ваш", "Нос", "Будет", "Кровоточить");

        toUpperCase(stream).forEach(System.out::println);
    }

    public static Stream<String> toUpperCase(Stream<String> strings) {
        //напишите тут ваш код
        return strings.map(String::toUpperCase);
    }
}
