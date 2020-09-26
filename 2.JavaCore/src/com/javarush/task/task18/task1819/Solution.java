package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try (FileInputStream file1r = new FileInputStream(str = reader.readLine());
             FileInputStream file2 = new FileInputStream(reader.readLine())) {
            byte[] buffer = new byte[file1r.available()];
            if (file1r.available() > 0) {
                file1r.read(buffer);
            }
            try (FileOutputStream file1w = new FileOutputStream(str)) {
                int i;
                while ((i = file2.read()) != -1) {
                    file1w.write(i);
                }
                file1w.write(buffer);
            }
        }
    }
}
