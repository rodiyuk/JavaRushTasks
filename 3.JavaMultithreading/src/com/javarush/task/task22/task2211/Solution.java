package com.javarush.task.task22.task2211;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String fileWin = args[0];
        String fileUTF = args[1];
        FileInputStream fis = new FileInputStream(fileWin);
        FileOutputStream fos = new FileOutputStream(fileUTF);
        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        String s = new String(buffer, "Windows-1251");
        buffer = s.getBytes("UTF-8");
        fos.write(buffer);
    }
}
