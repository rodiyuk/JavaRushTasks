package com.javarush.task.pro.task04.task0414;

import java.util.Scanner;

/* 
Хорошего не бывает много
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner sc  = new Scanner(System.in);
        String line = sc.nextLine();
        int number = sc.nextInt();
        do {
            if(number < 1 || number > 4){
                System.out.println(line);
                break;
            } else {
                System.out.println(line);
                number--;
            }
        } while (number > 0 && number < 5);
    }
}