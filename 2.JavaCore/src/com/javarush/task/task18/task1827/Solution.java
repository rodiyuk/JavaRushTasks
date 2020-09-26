package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            if (args.length != 0) {
                String productName;
                if (args[1].length() > 30)
                    productName = args[1].substring(0, 30);
                else productName = String.format("%-30s", args[1]);
                String price = String.format("%-8s", args[2]);
                String quantity = String.format("%-4s", args[3]);
                List<Integer> list = new ArrayList<>();
                while (reader.ready()) {
                    list.add(Integer.parseInt(reader.readLine().substring(0, 8).trim()));
                }
                String id = String.format("%-8s", Collections.max(list) + 1);
                writer.write("\n" + id + productName + price + quantity);
            }
        }
    }
}
