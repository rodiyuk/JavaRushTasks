package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader file1 = new BufferedReader(new FileReader(reader.readLine()));
             BufferedReader file2 = new BufferedReader(new FileReader(reader.readLine()))) {
            while (file1.ready()) {
                list1.add(file1.readLine());
            }
            while (file2.ready()) {
                list2.add(file2.readLine());
            }
        }
        for (int i = 0; i < list1.size(); ) {
                String s = list1.get(i);
                if(i < list2.size()){
                for (int j = i; j < list2.size(); ) {
                    String s1 = list2.get(j);
                    if (s.equals(s1)) lines.add(new LineItem(Type.SAME, s));
                    else if (i != (list1.size() - 1) && s.equals(list2.get(j + 1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(j)));
                        list1.add(i, list2.get(j));
                    } else {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        list2.add(i, list1.get(i));
                    }
                    break;
                }
            } else lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            i++;
            if (list2.size() > list1.size() && i == list1.size()){
                lines.add(new LineItem(Type.ADDED, list2.get(i)));
            }
        }
        lines.forEach(System.out::println);
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type.toString() + " " + line;
        }
    }
}
