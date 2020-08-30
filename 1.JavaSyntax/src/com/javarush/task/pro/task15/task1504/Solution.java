package com.javarush.task.pro.task15.task1504;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/* 
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try (Scanner scanner = new Scanner(System.in);
             InputStream filesIn = Files.newInputStream(Paths.get(scanner.nextLine()));
             OutputStream filesOut = Files.newOutputStream(Paths.get(scanner.nextLine()))) {
            int size = filesIn.available();
            if (size % 2 == 0) {
                for (int i = 0; i < size; i += 2) {
                    int first = filesIn.read();
                    int second = filesIn.read();
                    filesOut.write(second);
                    filesOut.write(first);
                }
            } else {
                for (int i = 0; i < size - 1; i += 2) {
                    int first = filesIn.read();
                    int second = filesIn.read();
                    filesOut.write(second);
                    filesOut.write(first);
                }
                int last = filesIn.read();
                filesOut.write(last);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

