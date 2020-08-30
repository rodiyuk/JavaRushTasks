package com.javarush.task.pro.task15.task1514;

import java.nio.file.Path;
import java.util.Scanner;

/* 
Все относительно
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        Path path1 = Path.of(sc.nextLine());
        Path path2 = Path.of(sc.nextLine());
        if (path1.relativize(path2).isAbsolute())
        System.out.println(path1.relativize(path2));
        else if (path2.relativize(path1).isAbsolute())
        System.out.println(path2.relativize(path1));
    }
}

