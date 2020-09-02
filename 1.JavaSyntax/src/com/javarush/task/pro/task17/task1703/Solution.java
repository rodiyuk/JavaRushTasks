package com.javarush.task.pro.task17.task1703;

import java.util.ArrayList;

/* 
Космическая одиссея ч.1
*/
public class Solution {
    public static ArrayList<Astronaut> spaceship = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
    }

    public static void createCrew(){
        //напишите тут ваш код
        Astronaut man = new Human();
        Astronaut woman = new Human();
        Astronaut cat = new Cat();
        Astronaut dog = new Dog();
        spaceship.add(man);
        spaceship.add(woman);
        spaceship.add(cat);
        spaceship.add(dog);
    }

    public static void printCrewInfo(){
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : spaceship) {
            System.out.println(astronaut.getInfo());
        }
    }
}
