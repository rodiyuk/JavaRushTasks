package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file = new BufferedReader(new FileReader(reader.readLine()))) {
            String[] split;
            while (file.ready()) {
                String line = file.readLine();
                split = line.split(" ");
                int count = 0;
                for (String s : split) {
                    for (String word : words) {
                        if (s.equals(word)) count++;
                    }
                }
                if (count == 2) System.out.println(line);
            }
        }
    }
}
