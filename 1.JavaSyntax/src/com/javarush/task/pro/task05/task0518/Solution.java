package com.javarush.task.pro.task05.task0518;

import java.util.Arrays;

/* 
Сортировка массива
*/
public class Solution {

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static int[] sort(int[] array) {
        //напишите тут ваш код
        Arrays.sort(array);
        return array;
    }

}
