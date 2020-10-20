package com.javarush.task.task22.task2209;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/* 
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...Киев Нью-Йорк Амстердам Вена Мельбурн
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        String[] split = new String[0];
        while (file.ready()) {
            split = file.readLine().split(" ");
        }
        StringBuilder result = getLine(split);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder("");
        List<String> list = new ArrayList<>(Arrays.asList(words));
        String word = list.get(0);
        list.remove(word);
        StringBuilder sb = new StringBuilder(word);
        for (int i = 0; i < list.size(); ) {
            String s = list.get(i);
            if (word.toLowerCase().charAt(word.length() - 1) == s.toLowerCase().charAt(0)) {
                sb.append(" ").append(s);
                list.remove(i);
                word = s;
                i = 0;
            } else i++;
        }
        return sb;
    }
}
