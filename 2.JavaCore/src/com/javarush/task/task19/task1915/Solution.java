package com.javarush.task.task19.task1915;

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileOutputStream file = new FileOutputStream(reader.readLine())) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            PrintStream console = System.out;
            PrintStream printStream = new PrintStream(stream);
            System.setOut(printStream);
            testString.printSomething();
            file.write(stream.toByteArray());
            System.setOut(console);
            System.out.println(stream.toString());
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

