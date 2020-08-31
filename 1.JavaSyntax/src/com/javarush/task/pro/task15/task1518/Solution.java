package com.javarush.task.pro.task15.task1518;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
А что же внутри папки?
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        Path path = Path.of(sc.nextLine());
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
            for (Path path1 : files) {
                if (Files.isRegularFile(path1))
                    System.out.println(path1 + " - это файл");
                if (Files.isDirectory(path1))
                    System.out.println(path1 + " - это директория");
            }
        }
    }
}

