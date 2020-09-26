package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            if (args.length != 0) {
                List<String> list = new ArrayList<>();
                while (reader.ready()) {
                    list.add(reader.readLine());
                }
                String id = String.format("%-8s", args[1]);
                switch (args[0]) {
                    case "-u":
                        String productName = String.format("%-30s", args[2]);
                        if (args[2].length() > 30)
                            productName = args[2].substring(0, 30);

                        String price = String.format("%-8s", args[3]);
                        if (args[3].length() > 8)
                            price = args[3].substring(0, 8);

                        String quantity = String.format("%-4s", args[4]);
                        if (args[4].length() > 4)
                            quantity = args[4].substring(0, 4);

                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).substring(0, 8).equals(id)) {
                                list.set(i, id + productName + price + quantity);
                            }
                        }
                        break;
                    case "-d":
                        list.removeIf(s -> s.substring(0, 8).equals(id));
                        break;
                }
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                    for (String s : list) {
                        writer.write(s + "\n");
                    }
                }
            }
        }
    }
}
