package com.javarush.task.task19.task1923;

/*
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        try (BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
             BufferedWriter file2 = new BufferedWriter(new FileWriter(fileName2))) {
            String[] split;
            while (file1.ready()) {
                split = file1.readLine().split(" ");

                for (String s : split) {
//                    if(s.matches(".+[0-9].+"))
                    int count = 0;
                    for (char ch : s.toCharArray()) {
                        if (Character.isDigit(ch)) count++;
                    }
                    if (count > 0)
                    file2.write(s + " ");
                }
            }
        }
    }
}
