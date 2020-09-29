package com.javarush.task.task19.task1908;

/*
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedWriter file2 = new BufferedWriter(new FileWriter(reader.readLine()))) {
            StringBuilder sb = new StringBuilder();
            while (file1.ready()) {
                sb.append((char)file1.read());
            }
            String[] arr = sb.toString().replaceAll("\\p{P}", " ").replaceAll("\\s", " ").split(" ");
            for (String s : arr) {
                try {
                    int x = Integer.parseInt(s);
                    file2.write(x + " ");
                } catch (NumberFormatException e){}
            }
        }
    }
}
