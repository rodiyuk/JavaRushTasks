package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            int min = fileInputStream.read();
            while (fileInputStream.available() > 0) {
                int current;
                if ((current = fileInputStream.read()) < min) {
                    min = current;
                }
            }
            System.out.println(min);
        }
    }
}
