package com.javarush.task.task16.task1630;

import java.io.*;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        try {
            System.out.println(f.getFileContent());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface ReadFileInterface{

        void setFileName(String fullFileName);

        String getFileContent() throws IOException;

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        BufferedReader fileIn;
        StringBuilder builder = new StringBuilder("");;

        @Override
        public void setFileName(String fullFileName) {
            try {
                fileIn = new BufferedReader(new FileReader(fullFileName));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent(){
            return builder.toString();
        }
        @Override
        public void run() {
            while (true){
                try {
                    if (!fileIn.ready()) break;
                } catch (IOException e) {
                }
                try {
                    builder.append(fileIn.readLine()).append(" ");
                } catch (IOException e) {
                }
            }
        }
    }
}
