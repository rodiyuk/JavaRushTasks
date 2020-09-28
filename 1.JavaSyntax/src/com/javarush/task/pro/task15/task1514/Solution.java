package com.javarush.task.pro.task15.task1514;

import java.io.IOException;
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
        try {
            System.out.println(path1.relativize(path2));
        } catch (Exception e) {
            try {
                System.out.println(path2.relativize(path1));
            } catch (Exception exception) {
            }
        }
    }
}

