package com.javarush.task.pro.task05.task0519;

import java.util.Arrays;

/* 
Есть ли кто?
*/
public class Solution {

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        System.out.println(contains(array, 5));
        System.out.println(contains(array, 99));
        System.out.println(contains(array, 1));
        System.out.println(contains(array, -15));
    }

    public static boolean contains(int[] array, int element) {
        //напишите тут ваш код
        int[] copy = Arrays.copyOf(array,array.length);
        Arrays.sort(copy);
        return Arrays.binarySearch(copy, element) >= 0;
    }

}
