package com.javarush.task.pro.task04.task0410;

import java.util.Scanner;

/* 
Второе минимальное число из введенных
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner console = new Scanner(System.in);
        int min = console.nextInt();
        int tmp = min;
        while (console.hasNextInt()) {
            int x = console.nextInt();
            if (x < min) {
                if (min <= tmp) tmp = min;
                min = x;
            } else if(x == min) continue;
            else if (x <= tmp) tmp = x;
        }
        System.out.println(tmp);
    }
}