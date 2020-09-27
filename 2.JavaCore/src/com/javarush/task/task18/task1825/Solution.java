package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String partName;
        String fileName = "";
        Set<String> set = new TreeSet<>();
        while (!(partName = reader.readLine()).equals("end")) {
            fileName = partName.substring(0, partName.lastIndexOf(".part"));
            set.add(partName);
        }
        BufferedInputStream fileReader;
        BufferedOutputStream fileWriter = new BufferedOutputStream(new FileOutputStream(fileName, true));
        for (String s : set) {
            fileReader = new BufferedInputStream(new FileInputStream(s));
            while (fileReader.available() > 0)
                fileWriter.write(fileReader.read());
            fileReader.close();
        }
        fileWriter.close();
    }
}
