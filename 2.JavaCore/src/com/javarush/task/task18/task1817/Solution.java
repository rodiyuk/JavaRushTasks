package com.javarush.task.task18.task1817;

import java.io.*;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        try(FileReader fileReader = new FileReader(fileName)){
            int countSpace = 0;
            int countAll = 0;
            while (fileReader.ready()){
                char b = (char) fileReader.read();
                countAll++;
                if(b == ' ') countSpace++;
            }
            System.out.printf("%.2f", (((countSpace * 1.0/ countAll) * 100)));
        }
    }
}
