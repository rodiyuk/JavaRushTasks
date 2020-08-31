package com.javarush.task.pro.task15.task1517;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* 
Файловые операции
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        Path path1 = Path.of(sc.nextLine());
        Path path2 = Path.of(sc.nextLine());
        if (!Files.exists(path1)) {
            Files.createFile(path1);
        } else {
            if (Files.notExists(path2)) Files.move(path1, path2);
            else Files.delete(path1);
        }
    }
}

