package com.javarush.task.pro.task09.task0906;

/* 
Двоичный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = Integer.MAX_VALUE;
        System.out.println("Десятичное число " + decimalNumber + " равно двоичному числу " + toBinary(decimalNumber));
        String binaryNumber = "1000";
        System.out.println("Двоичное число " + binaryNumber + " равно десятичному числу " + toDecimal(binaryNumber));
    }

    public static String toBinary(int decimalNumber) {
        if(decimalNumber <= 0) return "";
        String binary = "";
        while (decimalNumber != 0) {
            binary = (decimalNumber % 2) + binary;
            decimalNumber = decimalNumber / 2;
        }
        return binary;
        //напишите тут ваш код
    }

    public static int toDecimal(String binaryNumber) {
        //напишите тут ваш код
        if (binaryNumber == null || binaryNumber.equals("")) return 0;
        int decimal = 0;
        for (int i = binaryNumber.length() - 1, j = 0; i >= 0; i--, j++) {
            decimal += Integer.parseInt(String.valueOf(binaryNumber.charAt(i))) * Math.pow(2, j);
        }
        return decimal;
    }
}
