package com.javarush.task.pro.task05.task0508;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/* 
Удаляем одинаковые строки
*/

public class Solution {
    public static String[] strings = new String[10];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            strings[i] = sc.nextLine();
        }
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == null) continue;
            String line = strings[i];
            for (int j = i + 1; j < strings.length; j++) {
                if (line.equals(strings[j])) {
                    strings[i] = null;
                    strings[j] = null;
                }
            }
        }
        Arrays.stream(strings).forEach(System.out::println);
    }
}