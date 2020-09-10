package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(reader.readLine())))){
            ArrayList<Integer> list = new ArrayList<>();
            int i = 0;
            while (br.ready()){
                if ((i = Integer.parseInt(br.readLine()) )% 2 == 0) list.add(i);
            }
            Collections.sort(list);
            list.forEach(System.out::println);
        }
    }
}
