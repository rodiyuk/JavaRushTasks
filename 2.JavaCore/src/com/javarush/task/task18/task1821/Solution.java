package com.javarush.task.task18.task1821;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        Map<Integer, Integer> map = new TreeMap<>();
        while (fileReader.ready()) {
            int ch = fileReader.read();
            if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else map.put(ch, 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(Character.toChars(entry.getKey())[0] + " " + entry.getValue());
        }
        fileReader.close();
    }
}
