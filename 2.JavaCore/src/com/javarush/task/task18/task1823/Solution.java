package com.javarush.task.task18.task1823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("exit")) {
                break;
            }
            new ReadThread(fileName);
        }
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
            start();
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {

            try (FileInputStream file = new FileInputStream(fileName)) {
                Map<Integer, Integer> map = new HashMap<>();
                while (file.available() > 0) {
                    int b = file.read();
                    if (map.containsKey(b))
                        map.put(b, map.get(b) + 1);
                    else map.put(b, 1);
                }
                int max = 0;
                int key = 0;
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (entry.getValue() > max) {
                        max = entry.getValue();
                        key = entry.getKey();
                    }
                }
                resultMap.put(fileName, key);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

