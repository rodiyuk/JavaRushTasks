package com.javarush.task.task19.task1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Знакомство с тегами
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String tag = args[0];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine().replaceAll("\n\t", "");
        System.out.println(line.substring(line.indexOf("<" + tag), line.indexOf("</" + tag) + tag.length()+3));
    }
}
