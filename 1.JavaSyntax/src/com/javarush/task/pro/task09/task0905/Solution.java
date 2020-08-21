package com.javarush.task.pro.task09.task0905;

/* 
Восьмеричный конвертер
*/

public class Solution {
    public static void main(String[] args) {
        int decimalNumber = 21;
        System.out.println("Десятичное число " + decimalNumber + " равно восьмеричному числу " + toOctal(decimalNumber));
        int octalNumber = 25;
        System.out.println("Восьмеричное число " + octalNumber + " равно десятичному числу " + toDecimal(octalNumber));
    }

    public static int toOctal(int decimalNumber) {
        //напишите тут ваш код
        if(decimalNumber <= 0) return 0;
        int octal = 0;
        int i = 0;
        while (decimalNumber / 8 != 0) {
            octal += (decimalNumber % 8) * Math.pow(10, i);
            decimalNumber = decimalNumber / 8;
            i++;
        }
        return (int) (octal + decimalNumber * Math.pow(10, i));
    }

    public static int toDecimal(int octalNumber) {
        //напишите тут ваш код
        if(octalNumber <= 0) return 0;
        int decimal = 0;
        int i = 0;
        while (octalNumber / 8 != 0) {
            decimal += (octalNumber % 10) * Math.pow(8, i);
            octalNumber = octalNumber / 10;
            i++;
        }
        return (int) (decimal + octalNumber * Math.pow(8, i));
    }
}
