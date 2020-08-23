package com.javarush.task.pro.task03.task0313;

public class Solution {
    public static String string1 = "Амиго";
    public static String string2 = string1;
    public static String string3 = new String(string1);

    public static void main(String[] args) {
        if (string1 == string2) System.out.println("ссылки на строки одинаковые");
        else System.out.println("ссылки на строки разные");
        if (string1 == string3) System.out.println("ссылки на строки одинаковые");
        else System.out.println("ссылки на строки разные");
        if (string2 == string3) System.out.println("ссылки на строки одинаковые");
        else System.out.println("ссылки на строки разные");
    }

}
