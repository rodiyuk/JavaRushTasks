package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try(FileWriter file1 = new FileWriter(reader.readLine(),true);
            FileReader file2 = new FileReader(reader.readLine());
            FileReader file3 = new FileReader(reader.readLine())){
            while (file2.ready()){
                file1.write(file2.read());
            }
            while (file3.ready()){
                file1.write(file3.read());
            }
        }
    }
}
