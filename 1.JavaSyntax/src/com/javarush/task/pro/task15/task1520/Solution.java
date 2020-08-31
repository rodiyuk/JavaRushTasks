package com.javarush.task.pro.task15.task1520;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Глубокое копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        Path path1 = Path.of(sc.nextLine());
        Path path2 = Path.of(sc.nextLine());
        if (Files.notExists(path2)) Files.createDirectory(path2);
        copyDirectory(path1, path2);
    }
    public static void copyDirectory(Path source, Path dest) throws IOException {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(source)) {
            for (Path path : files) {
                Files.copy(path, dest.resolve(path.getFileName()));
                if (Files.isDirectory(path)) {
                    copyDirectory(path, dest.resolve(path.getFileName()));
                }
            }
        }
    }
}

