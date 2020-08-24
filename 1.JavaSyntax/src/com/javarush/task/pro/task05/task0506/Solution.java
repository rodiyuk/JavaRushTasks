package com.javarush.task.pro.task05.task0506;

import java.io.IOException;
import java.util.Scanner;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] intArray = getIntArray();
        System.out.println(getMinimum(intArray));
    }

    public static int getMinimum(int[] array) {
        //напишите тут ваш код
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] < min) min = array[i];
        }
        return min;
    }

    public static int[] getIntArray() throws IOException {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }
}
