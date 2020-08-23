package com.javarush.task.pro.task09.task0914;

/* 
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "C:\\Program Files\\Java\\jdk1.8\\bin";

        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        //напишите тут ваш код
        int index = path.lastIndexOf("\\");
        int index2 = path.lastIndexOf("\\", index-1);
        return path.replaceAll(path.substring(index2+1, index), jdk);
    }
}
