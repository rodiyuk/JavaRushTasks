package com.javarush.task.pro.task15.task1507;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        try (BufferedReader reader = new BufferedReader(new FileReader(sc.nextLine()))) {
            while (reader.ready()) {
                System.out.println(reader.readLine());
                reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

