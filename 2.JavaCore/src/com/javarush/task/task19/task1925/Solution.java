package com.javarush.task.task19.task1925;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];
        try (BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
             BufferedWriter file2 = new BufferedWriter(new FileWriter(fileName2))) {
            String[] split;
            StringBuilder sb = new StringBuilder();
            while (file1.ready()) {
                split = file1.readLine().split(",");
                for (String s : split) {
                    if (s.length() > 6)
                        sb.append(s).append(" ");
                }
            }
            String result = sb.toString().trim().replaceAll(" ", ",");
            file2.write(result);
        }
    }
}
