package com.javarush.task.pro.task05.task0508;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String[] strings = getStringArray();
        String[] result = removeSameStrings(strings);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static String[] removeSameStrings(String[] stringArray) {
        //напишите тут ваш код
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == null) continue;
            String line = stringArray[i];
            for (int j = i + 1; j < stringArray.length -1; j++) {
                if (line.equals(stringArray[j])) {
                    stringArray[i] = null;
                    stringArray[j] = null;
                }
            }
        }
        return stringArray;
    }

    public static String[] getStringArray() throws IOException {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        String[] arr = new String[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = sc.nextLine();
        }
        return arr;
    }
}
