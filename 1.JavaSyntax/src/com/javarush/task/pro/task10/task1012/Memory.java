package com.javarush.task.pro.task10.task1012;

import java.util.Arrays;

/* 
Дефрагментация памяти
*/
public class Memory {
    public static final String[] MEMORY = {"object15", null, null, "object2",
            null, null, null, "object32", null, "object4"};

    public static void defragmentation(String[] array) {
        //напишите тут ваш код
        String tmp;
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length-1; j++) {
                if (array[i] == null){
                    tmp = array[i];
                    array[i] = array[j+1];
                    array[j+1] = tmp;
                }

            }
        }
    }

    public static void main(String[] args) {
        defragmentation(MEMORY);
        Arrays.stream(MEMORY).forEach(System.out::println);
    }
}
