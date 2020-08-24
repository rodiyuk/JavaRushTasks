package com.javarush.task.pro.task05.task0507;

import java.io.IOException;
import java.util.Scanner;

/* 
Максимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] intArray = getIntArray();
        System.out.println(getMaximum(intArray));
    }

    public static int getMaximum(int[] array) {
        //напишите тут ваш код
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max) max = array[i];
        }
        return max;
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
