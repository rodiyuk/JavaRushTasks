package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter file2 = new BufferedWriter(new FileWriter(reader.readLine()))) {
            while (file1.ready()){
                String[] num = file1.readLine().split(" ");
                for (String s : num) {
                    file2.write(Math.round(Double.parseDouble(s)) + " ");
                }
            }
        }
    }
}
