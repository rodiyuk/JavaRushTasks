package com.javarush.task.task18.task1816;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        try(BufferedInputStream fileReader = new BufferedInputStream(new FileInputStream(fileName))){
            int count = 0;
            while (fileReader.available() > 0){
                char b = (char) fileReader.read();
                if((b >='A' && b <='Z') || (b >= 'a' && b<= 'z')) count++;
            }
            System.out.println(count);
        }
    }
}
