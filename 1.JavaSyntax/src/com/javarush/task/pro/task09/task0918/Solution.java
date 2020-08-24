package com.javarush.task.pro.task09.task0918;

/* 
Поработаем со StringBuilder
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Учиться, учиться и еще раз учиться! ";

        System.out.println(create(string));
        System.out.println(addTo(string, new String[]{"Под ", "лежачий ", "камень ", "вода ", "не ", "течет"}));
        System.out.println(deleteFrom(string, string.length() - 2));
        System.out.println(replace(string, ", ", 16, 27));
    }

    public static StringBuilder create(String string) {
        //напишите тут ваш код
        return new StringBuilder(string);
    }

    public static StringBuilder addTo(String string, String[] strings) {
        //напишите тут ваш код
        StringBuilder builder = new StringBuilder(string);
        for (String s : strings) {
            builder.append(s);
        }
        return builder;
    }

    public static StringBuilder deleteFrom(String string, int index) {
        //напишите тут ваш код
        return new StringBuilder(string).deleteCharAt(index);
    }

    public static StringBuilder replace(String string, String str, int start, int end) {
        //напишите тут ваш код
        return new StringBuilder(string).replace(start, end, str);
    }
}
