package com.javarush.task.pro.task18.task1814;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/* 
Уникальные слова
*/

public class Solution {

    public static void main(String[] args) {
        var strings = new ArrayList<String>();
        Collections.addAll(strings, "чтобы", "стать", "программистом", "нужно", "программировать",
                "а", "чтобы", "программировать", "нужно", "учиться");

        Stream<String> distinct = getDistinct(strings);
        distinct.forEach(System.out::println);
    }

    public static Stream<String> getDistinct(ArrayList<String> strings) {
        //напишите тут ваш код
        return strings.stream().distinct();
    }
}
