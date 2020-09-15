package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;/*
Парсер реквестов
*/
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String URL = reader.readLine();
        String par = URL.substring(URL.indexOf("?") + 1);
        String[] array = par.split("&");
        ArrayList<String> param = new ArrayList<>();
        ArrayList<String> value = new ArrayList<>();
        for (String arr : array) {
            if (arr.contains("=")) {
                param.add(arr.split("=")[0]);
                value.add(arr.split("=")[1]);
                System.out.print(arr.endsWith("=") + " ");
            } else System.out.print(arr + " ");
        }
        for (String arr : array) {
            if (arr.contains("obj")) {
                if (arr.substring(arr.indexOf("="), 1).contains(".")) ar
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
