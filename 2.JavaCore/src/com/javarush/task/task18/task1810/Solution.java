package com.javarush.task.task18.task1810;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try (FileInputStream file = new FileInputStream(reader.readLine())) {
                if(file.available()<1000){
                    throw new DownloadException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
