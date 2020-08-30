package com.javarush.task.pro.task15.task1510;

import java.io.*;
import java.util.Scanner;

/* 
Пишем байты в файл
*/

public class Solution {
    public static void main(String[] args) {
        try (InputStream stream = System.in;
             Scanner scanner = new Scanner(stream);
             FileOutputStream fos = new FileOutputStream(scanner.nextLine())) {
            byte[] bytes = new byte[]{101, 102, 103, 104, 105};
            fos.write(bytes);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

