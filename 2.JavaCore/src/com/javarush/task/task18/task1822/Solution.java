package com.javarush.task.task18.task1822;

import java.io.*;

/* 
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(BufferedReader file = new BufferedReader (new FileReader(reader.readLine()))){
            while (file.ready()){
                String line = file.readLine();
                int id = Integer.parseInt(line.split(" ")[0]);
                if (id == Integer.parseInt(args[0])){
                    System.out.println(line);
                }
            }
        }
    }
}
