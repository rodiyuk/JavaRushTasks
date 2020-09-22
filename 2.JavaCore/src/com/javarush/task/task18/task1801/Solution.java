package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            int max = fileInputStream.read();
            while (fileInputStream.available() > 0) {
                int current;
                if ((current = fileInputStream.read()) > max) {
                    max = current;
                }
            }
            System.out.println(max);
        }
    }
}
