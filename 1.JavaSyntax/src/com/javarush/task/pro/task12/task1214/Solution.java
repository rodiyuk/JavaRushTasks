package com.javarush.task.pro.task12.task1214;

import java.util.ArrayList;
import java.util.Arrays;

/* 
Останется только Java
*/
public class Solution {
    public static ArrayList<String> programmingLanguages =
            new ArrayList<>(Arrays.asList("C", "C++", "Python", "JavaScript", "Ruby", "Java", "Pascal"));

    public static void main(String[] args) {
        //напишите тут ваш код
        for (int i = 0; i < programmingLanguages.size(); i++) {
            if(!programmingLanguages.get(i).equals("Java")){
                programmingLanguages.remove(i);
                i--;
            }
        }
        for (String s : programmingLanguages) System.out.println(s);
    }
}
