package com.javarush.task.pro.task17.task1705;

import java.util.ArrayList;

/* 
Космическая одиссея ч.3
*/
public class Solution {
    public static ArrayList<Astronaut> spaceship = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
        runWorkingProcess();
    }

    public static void runWorkingProcess() {
        //напишите тут ваш код
        for (var astronaut : spaceship){
            if (astronaut instanceof Human) pilot((Human)astronaut);
            if (astronaut instanceof Dog) createDirection((Dog) astronaut);
            if (astronaut instanceof Cat) research((Cat) astronaut);
        }
    }

    public static void pilot(Human human) {
        System.out.println("Член экипажа " + human.getInfo() + " пилотирует корабль.");
    }

    public static void createDirection(Dog dog) {
        System.out.println("Член экипажа " + dog.getInfo() + " занимается созданием навигационного маршрута.");
    }

    public static void research(Cat cat) {
        System.out.println("Член экипажа " + cat.getInfo() + " исследует ближайшие планеты.");
    }

    public static void createCrew() {
        spaceship.add(new Human());
        spaceship.add(new Human());
        spaceship.add(new Dog());
        spaceship.add(new Cat());
    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : spaceship) {
            System.out.println(astronaut.getInfo());
        }
    }
}
