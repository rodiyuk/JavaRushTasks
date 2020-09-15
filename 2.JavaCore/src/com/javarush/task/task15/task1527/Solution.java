package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;/*
Парсер реквестов
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        String par = URL.substring(URL.indexOf("?") + 1);
        String[] array = par.split("&");
//        Arrays.stream(array).forEach(System.out::println);
        Map<String, String> param = new HashMap<>();
        for (String arr : array) {
            if (arr.contains("=")) {
                param.put(arr.split("=")[0], arr.split("=")[1]);
                System.out.print(arr.split("=")[0] + " ");
            } else {
                param.put(arr, null);
                System.out.print(arr + " ");
            }
        }
        System.out.println();
        for (Map.Entry<String, String> entry : param.entrySet()) {
            if (entry.getKey().equals("obj")) {
                try {
                    double d = Double.parseDouble(entry.getValue());
                    alert(d);
                } catch (NumberFormatException e) {
                    alert(entry.getValue());
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
