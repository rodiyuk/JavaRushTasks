package com.javarush.task.pro.task15.task1519;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

/* 
Поверхностное копирование
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        Path path1 = Path.of(sc.nextLine());
        Path path2 = Path.of(sc.nextLine());
        if (Files.notExists(path2)) Files.createDirectories(path2);
        try (DirectoryStream<Path> files = Files.newDirectoryStream(path1)) {
            for (Path path : files) {
                if (Files.isRegularFile(path)) {
                    Files.copy(path, path2.resolve(path.getFileName()));
                }
            }
        }
    }
}

