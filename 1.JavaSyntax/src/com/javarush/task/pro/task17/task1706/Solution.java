package com.javarush.task.pro.task17.task1706;

/* 
Хищники vs Травоедные
*/
public class Solution {
    public static void main(String[] args) {
        printRation(new Cow());
        printRation(new Lion());
        printRation(new Elephant());
        printRation(new Wolf());
    }

    public static void printRation(Animal animal){
        //напишите тут ваш код
        if (animal instanceof Cow || animal instanceof Elephant)
            System.out.println("Любит траву");
        if (animal instanceof Lion || animal instanceof Wolf)
            System.out.println("Любит мясо");
    }
}
