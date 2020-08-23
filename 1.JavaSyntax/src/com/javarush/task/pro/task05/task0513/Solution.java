package com.javarush.task.pro.task05.task0513;

import java.util.Arrays;

/* 
Выводим массив
*/

public class Solution {

    public static void main(String[] args) {
        var strings = new String[]{"I", "love", "Java"};
        var ints = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        printStringArray(strings);
        printIntArray(ints);
    }

    public static void printStringArray(String[] array) {
        //напишите тут ваш код
        System.out.println(Arrays.toString(array));
    }

    public static void printIntArray(int[] array) {
        //напишите тут ваш код
        System.out.println(Arrays.toString(array));
    }
}
