package com.javarush.task.pro.task05.task0515;

import java.util.Arrays;

/* 
Сравнение двухмерных массивов
*/
public class Solution {

    public static void main(String[] args) {
        int[][] stringsFirst = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] stringsSecond = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(compareArrays(stringsFirst, stringsSecond));
    }

    public static boolean compareArrays(int[][] arrayFirst, int[][] arraySecond) {
        return Arrays.deepEquals(arrayFirst, arraySecond);
    }
}
