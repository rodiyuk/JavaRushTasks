package com.javarush.task.task22.task2207;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder sb = new StringBuilder();
        while (file.ready()) {
            sb.append(file.readLine()).append(" ");
        }
        file.close();
        String[] strings = sb.toString().trim().split(" ");
        for (int i = 0; i < strings.length - 1; i++) {
            String string = strings[i];
            for (int j = i + 1; j < strings.length; j++) {
                String reverse = new StringBuilder(strings[j]).reverse().toString();
                if (string.equals(reverse)) {
                    Pair pair = new Pair();
                    pair.first = string;
                    pair.second = strings[j];
                    if (!result.contains(pair))
                    result.add(pair);
                }
            }
        }
        result.stream().forEach(pair -> System.out.println(pair));
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
