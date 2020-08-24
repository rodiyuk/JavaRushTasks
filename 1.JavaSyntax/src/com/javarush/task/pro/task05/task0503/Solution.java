package com.javarush.task.pro.task05.task0503;

import java.util.Arrays;

/* 
Работаем с элементами массива
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(changeSign(new int[]{1, 2, 3, -4, 5, 6, 7, 8, 9})));
    }

    public static int[] changeSign(int[] array) {
        //напишите тут ваш код
        for (int i = 0; i < array.length; i++) {
            if(array[i]%2==0) array[i] = -array[i];
        }
        return array;
    }
}
