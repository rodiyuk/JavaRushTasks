package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            Set<Integer> set = new TreeSet<>();
            while (fileInputStream.available() > 0) {
                set.add(fileInputStream.read());
            }
            for (Integer integer : set) {
                System.out.print(integer + " ");
            }
        }
    }
}