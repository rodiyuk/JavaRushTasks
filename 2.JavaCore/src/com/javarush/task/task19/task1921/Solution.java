package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        ArrayList<String> list = new ArrayList<>();
        try (BufferedReader file = new BufferedReader(new FileReader(fileName))) {
            while (file.ready()) {
                list.add(file.readLine());
            }
        }
        for (String s : list) {
            String[] splitLine = s.split(" ");
            int day = Integer.parseInt(splitLine[splitLine.length - 3]);
            int month = Integer.parseInt(splitLine[splitLine.length - 2]) - 1;
            int year = Integer.parseInt(splitLine[splitLine.length - 1]) - 1900;
            Date bd = new Date(year, month, day);
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < splitLine.length - 3; i++) {
                String s1 = splitLine[i];
                name.append(s1 + " ");
            }
            PEOPLE.add(new Person(name.toString().trim(), bd));
        }
        PEOPLE.forEach(System.out::println);

    }
}
