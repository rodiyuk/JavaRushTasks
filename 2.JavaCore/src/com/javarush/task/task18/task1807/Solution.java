package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fis = new FileInputStream(reader.readLine())) {
            int count = 0;
            while (fis.available() > 0) {
                if (fis.read()==44) count++;
            }
            System.out.println(count);
        }
    }
}
