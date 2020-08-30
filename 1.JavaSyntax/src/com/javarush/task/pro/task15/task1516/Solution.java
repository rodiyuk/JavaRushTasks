package com.javarush.task.pro.task15.task1516;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файл или директория
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if (Files.exists(Path.of(line))) {
                if (Files.isRegularFile(Path.of(line))) {
                    System.out.println(line + " - это файл");
                }
                if (Files.isDirectory(Path.of(line))) {
                    System.out.println(line + " - это директория");
                }
            } else break;
        }
    }
}

