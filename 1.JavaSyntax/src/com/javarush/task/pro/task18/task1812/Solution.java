package com.javarush.task.pro.task18.task1812;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;

/* 
Рейтинг языков программирования
*/

public class Solution {

    public static void main(String[] args) {
        ArrayList<Language> languages = new ArrayList<>();
        Collections.addAll(languages,
                new Language("С#", 13.7),
                new Language("Scala", 1.1),
                new Language("JavaScript", 18.4),
                new Language("Python", 13.2),
                new Language("Kotlin", 2.7),
                new Language("TypeScript", 4.4),
                new Language("C++", 5.8),
                new Language("Go", 1.8),
                new Language("Java", 15.4),
                new Language("C", 1.5),
                new Language("Swift", 2.8),
                new Language("PHP", 10.8));

        Stream<Language> studentStream = sortByRating(languages);
        studentStream.forEach(System.out::println);
    }

    public static Stream<Language> sortByRating(ArrayList<Language> languages) {
        //напишите тут ваш код

//        return languages.stream().sorted((l1, l2) -> (int) (l1.getRating() - l2.getRating()));
        return languages.stream().sorted(Comparator.comparingDouble(Language::getRating));
    }
}
