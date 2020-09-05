package com.javarush.task.pro.task18.task1804;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* 
Знакомство с лямбда-выражением
*/

public class Solution {

    public static void main(String[] args) {
        var numbers = new ArrayList<Integer>();

        Collections.addAll(numbers, 123, -6, 12, 0, 44, 5678, -350);

        sortNumbers(numbers);
        numbers.forEach(System.out::println);
    }

    public static void sortNumbers(ArrayList<Integer> numbers) {
        Collections.sort(numbers, (n1, n2) -> n1 - n2);
    }
}
