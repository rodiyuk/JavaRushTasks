package com.javarush.task.pro.task05.task0509;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        int [][] table = new int [10][10];
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = (i+1)*(j+1);
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }
}
