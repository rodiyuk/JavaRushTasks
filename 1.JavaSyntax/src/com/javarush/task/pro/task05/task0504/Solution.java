package com.javarush.task.pro.task05.task0504;

import java.util.Arrays;

/* 
Объеденяем массивы
*/
public class Solution {

    public static void main(String[] args) {
        int[] firstArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] secondArray = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        System.out.println(Arrays.toString(mergeArrays(firstArray, secondArray)));
    }

    public static int[] mergeArrays(int[] firstArray, int[] secondArray) {
        //напишите тут ваш код
        int[] sum = new int[firstArray.length + secondArray.length];
        for (int j = 0; j < firstArray.length; j++) {
            sum[j] = firstArray[j];
        }
        for (int i = 0; i < secondArray.length; i++) {
            sum[i + firstArray.length] = secondArray[i];
        }
        return sum;
    }
}
