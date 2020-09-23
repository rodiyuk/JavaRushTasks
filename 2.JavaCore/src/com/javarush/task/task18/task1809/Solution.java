package com.javarush.task.task18.task1809;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream file1 = new FileInputStream(reader.readLine());
             FileOutputStream file2 = new FileOutputStream(reader.readLine())) {
            byte[] buffer = new byte[file1.available()];
            file1.read(buffer);
            for (int i = buffer.length - 1; i >= 0; i--) {
                byte b = buffer[i];
                file2.write(b);
            }
        }

    }
}
