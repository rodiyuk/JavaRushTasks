package com.javarush.task.pro.task05.task0516;

import java.util.Arrays;

/* 
Заполняем массив
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(fillArray(new int[4], 1, 2)));
    }

    public static int[] fillArray(int[] array, int valueStart, int valueEnd) {
        //напишите тут ваш код
        if (array.length%2==0){
            Arrays.fill(array,0, array.length/2,valueStart);
            Arrays.fill(array,array.length/2,array.length,valueEnd);
        } else {
            Arrays.fill(array,0, array.length/2+1,valueStart);
            Arrays.fill(array,array.length/2+1,array.length,valueEnd);
        }
        return array;
    }

}
