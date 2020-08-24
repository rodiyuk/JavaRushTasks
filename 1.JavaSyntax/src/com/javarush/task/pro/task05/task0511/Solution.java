package com.javarush.task.pro.task05.task0511;

import java.util.Scanner;

/* 
Создаем двухмерный массив
*/

public class Solution {

    public static int[][] createMultiArray() throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int n;
        while(true){
            if((n = sc.nextInt())>0) break;
        }
        int [][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[sc.nextInt()];
        }
        return arr;
    }

}
