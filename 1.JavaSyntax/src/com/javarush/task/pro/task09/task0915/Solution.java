package com.javarush.task.pro.task09.task0915;

import java.util.Arrays;
import java.util.StringTokenizer;

/* 
StringTokenizer
*/

public class Solution {
    public static void main(String[] args) {
        String packagePath = "com.javarush.task.pro.task09.task0915";
        String[] tokens = getTokens(packagePath, ".");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        //напишите тут ваш код
        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);
        String[] strings = new String[tokenizer.countTokens()];
        while (tokenizer.hasMoreTokens()){
            for (int i = 0; i < strings.length; i++) {
                strings[i] = tokenizer.nextToken();
            }
        }
        return strings;
    }
}
