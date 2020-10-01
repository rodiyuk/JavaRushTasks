package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader file = new BufferedReader(new FileReader(reader.readLine()))){
            while (file.ready()){
                StringBuilder sb = new StringBuilder(file.readLine());
                System.out.println(sb.reverse());
            }
        }
    }
}
