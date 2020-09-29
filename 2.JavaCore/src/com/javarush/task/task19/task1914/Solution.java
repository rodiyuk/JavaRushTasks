package com.javarush.task.task19.task1914;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;/*
Решаем пример
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        testString.printSomething();
        String[] result = stream.toString().split(" ");
        System.setOut(console);
        int a = Integer.parseInt(result[0]);
        int b = Integer.parseInt(result[2]);
        int c = 0;
        switch (result[1]) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
        }
        System.out.printf("%d %s %d = %d", a, result[1], b, c);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

