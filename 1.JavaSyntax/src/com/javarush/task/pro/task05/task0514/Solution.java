package com.javarush.task.pro.task05.task0514;

import java.util.Arrays;

/* 
Выводим двухмерный массив
*/
public class Solution {

    public static void main(String[] args) {
        var strings = new String[][]{{"🙂", "🙂", "🙂", "🙂"}, {"🙃", "🙃", "🙃", "🙃"}, {"😋", "😋", "😋", "😋"}, {"😎", "😎", "😎", "😎"},};
        var ints = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printStringMultiArray(strings);
        printIntMultiArray(ints);
    }

    public static void printStringMultiArray(String[][] array) {
        //напишите тут ваш код
        System.out.println(Arrays.deepToString(array));
    }

    public static void printIntMultiArray(int[][] array) {
        //напишите тут ваш код
        System.out.println(Arrays.deepToString(array));
    }
}
