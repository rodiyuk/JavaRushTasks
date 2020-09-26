package com.javarush.task.task18.task1826;

import java.io.*;

/* 
Шифровка  -e fileName fileOutputName
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[1]));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[2]))) {
            switch (args[0]) {
                case "-e":
                    while (inputStream.available() > 0) {
                        outputStream.write(inputStream.read() ^ 1);
                    }
                    break;
                case "-d":
                    while (inputStream.available() > 0) {
                        outputStream.write(inputStream.read() ^ 1);
                    }
                    break;
            }
        }
    }
}
