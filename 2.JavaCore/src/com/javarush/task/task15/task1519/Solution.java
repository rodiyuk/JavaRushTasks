package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = reader.readLine();
            try {
                if (line.equals("exit")) break;
                if (line.contains(".")) print(Double.parseDouble(line));
                else if (Integer.parseInt(line) > 0 && Integer.parseInt(line) < 128) print(Short.parseShort(line));
                else if (Integer.parseInt(line) <= 0 || Integer.parseInt(line) >= 128) print(Integer.parseInt(line));
            } catch (NumberFormatException e) {
                print(line);
            }

        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
