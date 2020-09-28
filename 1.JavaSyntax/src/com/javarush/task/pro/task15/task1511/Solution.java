package com.javarush.task.pro.task15.task1511;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Пишем символы в файл
*/

public class Solution {
    public static void main(String[] args) {
        try (InputStream stream = System.in;
             Scanner scanner = new Scanner(stream);
             BufferedWriter output = Files.newBufferedWriter(Path.of(scanner.nextLine()))) {
            char[] chars = new char[]{'j', 'a', 'v', 'a'};
                output.write(chars);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

