package com.javarush.task.pro.task05.task0502;

/* 
Четные и нечетные ячейки массивы
*/
public class Solution {
    public static final String ODD = "Нечётный";
    public static final String EVEN = "Чётный";

    public static void main(String[] args) {
        String[] strings = fillArray(new String[20]);

        for (int i = 0; i < strings.length; i++) {
            System.out.print("index = " + i);
            System.out.println(" value = " + strings[i]);
        }
    }
    public static String[] fillArray(String[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (i%2==0) arr[i] = EVEN;
            else arr[i] = ODD;
        }
        return arr;
    }
    //напишите тут ваш код

}
