package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(args[0]))) {
            while (file.ready()) {
                list.add(file.readLine());
            }
        }
        String[] name = new String[list.size()];
        double[] value = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            name[i] = list.get(i).split(" ")[0];
            double[i] = Double.parseDouble(list.get(i).split(" ")[1]);
        }
    }
}
