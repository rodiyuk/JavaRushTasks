package com.javarush.task.pro.task15.task1506;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/* 
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        try (FileReader reader = new FileReader(new Scanner(System.in).nextLine()))
        {
            while (reader.ready()){
                char ch = (char) reader.read();
                if (ch != ' ' && ch != ',' && ch != '.')
                    System.out.print(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

