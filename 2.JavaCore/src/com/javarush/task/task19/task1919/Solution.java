package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))) {
            String line;
            String name;
            double value;
            while (file.ready()) {
                line = file.readLine();
                name = line.split(" ")[0];
                value = Double.parseDouble(line.split(" ")[1]);
                if (map.containsKey(name)) {
                    map.put(name, map.get(name) + value);
                } else map.put(name, value);
            }
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
