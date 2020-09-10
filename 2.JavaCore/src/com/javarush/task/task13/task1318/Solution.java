package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(reader.readLine())) {
            while (fis.available() > 0) {
                System.out.print((char)fis.read());
            }
        }
    }
}