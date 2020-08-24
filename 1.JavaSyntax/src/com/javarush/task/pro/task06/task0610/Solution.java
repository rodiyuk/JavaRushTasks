package com.javarush.task.pro.task06.task0610;

/* 
Борьба за доступ
*/

public class Solution {
    public static void main(String[] args) {
        Person person = new Person("Mark", "Zuckerberg");
        System.out.println("Досье.");
        System.out.println("Имя : " + person.getName());
        System.out.println("Фамилия : " + person.getSurname());
        System.out.println("Полное имя : " + person.getFullName());
    }
}
