package com.javarush.task.pro.task05.task0510;

/* 
Бином Ньютона
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
//        int [][] binom = new int [10][10];
        int [][] binom = {{1},{1,1},{1,2,1},{1,3,3,1},{1,4,6,4,1},{1,5,10,10,5,1},{1,6,15,20,15,6,1},{1,7,21,35,
        35,21,7,1},{1,8,28,56,70,56,28,8,1},{1,9,36,84,126,126,84,36,9,1}};
        for (int i = 0; i < binom.length; i++) {
            for (int j = 0; j < binom[i].length; j++) {
                System.out.print(binom[i][j] + " ");
            }
            System.out.println();
        }
    }
}
