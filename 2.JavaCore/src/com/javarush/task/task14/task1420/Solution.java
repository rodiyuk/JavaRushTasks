package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Введите первое число: ");
                int a = Integer.parseInt(reader.readLine());
                System.out.print("Введите второе число: ");
                int b = Integer.parseInt(reader.readLine());
                System.out.printf("Наибольший общий делитель чисел %d и %d: %d\n", a, b, nod(a, b));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Вы ввели текст. Должны быть числа");
            }
        }
    }

    public static int nod(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        ArrayList<Integer> listA = new ArrayList<>();
        ArrayList<Integer> listB = new ArrayList<>();
        for (int i = 1; i <= a; i++) {
            if (a % i == 0) listA.add(i);
        }
        for (int i = 1; i <= b; i++) {
            if (b % i == 0) listB.add(i);
        }
        for (int i = listA.size() - 1; i > 0; i--) {
            for (int j = 0; j < listB.size(); j++) {
                if (listA.get(i) == listB.get(j))
                    return listA.get(i);
            }
        }
        return 1;
    }
}
