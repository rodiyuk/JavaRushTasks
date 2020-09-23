package com.javarush.task.task18.task1808;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream file1 = new FileInputStream(reader.readLine());
             FileOutputStream file2 = new FileOutputStream(reader.readLine());
             FileOutputStream file3 = new FileOutputStream(reader.readLine())) {
            byte[] buffer = new byte[file1.available()];
            file1.read(buffer);
            if (buffer.length % 2 == 0) {
                file2.write(buffer, 0, buffer.length / 2);
                file3.write(buffer, buffer.length / 2, buffer.length / 2);
            } else {
                file2.write(buffer, 0, buffer.length / 2 + 1);
                file3.write(buffer, buffer.length / 2 + 1, buffer.length / 2);
            }
        }
    }
}
