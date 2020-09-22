package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try (FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            int count = 1;
            Map<Integer, Integer> map = new HashMap<>();
            map.put(fileInputStream.read(), count);
            int current;
            while (fileInputStream.available() > 0) {
                current = fileInputStream.read();
                if (map.containsKey(current)) {
                    map.put(current, map.get(current) + 1);
                } else map.put(current, count);
            }
            int min = Integer.MAX_VALUE;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() < min) {
                    min = entry.getValue();
                }
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == min) {
                    System.out.print(entry.getKey() + " ");
                }
            }
        }
    }
}