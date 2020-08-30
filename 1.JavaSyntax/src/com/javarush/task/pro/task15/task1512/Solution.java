package com.javarush.task.pro.task15.task1512;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/* 
Задом наперед
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        PrintStream console = System.out;
        System.setOut(stream);
        printSomething("it's a text for testing");
        //напишите тут ваш код
        System.setOut(console);
        byte [] bytes = baos.toByteArray();
        for (int i = bytes.length - 1; i >= 0; i--) {
            System.out.print((char)bytes[i]);
        }
    }

    public static void printSomething(String str) {
        System.out.print(str);
    }
}

