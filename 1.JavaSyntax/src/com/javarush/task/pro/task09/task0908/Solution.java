package com.javarush.task.pro.task09.task0908;

/* 
Двоично-шестнадцатеричный конвертер
*/

public class Solution {
    private static final String HEX = "0123456789abcdef";

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        //напишите тут ваш код
        if (binaryNumber == null || binaryNumber.equals("")) return "";
        int decimal = 0;
        for (int i = binaryNumber.length() - 1, j = 0; i >= 0; i--, j++) {
            decimal += Integer.parseInt(String.valueOf(binaryNumber.charAt(i))) * Math.pow(2, j);
        }
        String hex = "";
        while (decimal != 0) {
            hex = HEX.charAt(decimal % 16) + hex;
            decimal = decimal / 16;
        }
        return hex;
    }

    public static String toBinary(String hexNumber) {
        //напишите тут ваш код
        if (hexNumber == null || hexNumber.equals("")) return "";
        int decimal = 0;
        for (int i = 0; i < hexNumber.length(); i++) {
            decimal = 16 * decimal + HEX.indexOf(hexNumber.charAt(i));
        }
        String binary = "";
        while (decimal != 0) {
            binary = (decimal % 2) + binary;
            decimal = decimal / 2;
        }
        return binary;
    }
}
