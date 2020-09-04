package com.javarush.task.pro.task17.task1715;

import java.util.ArrayList;

/* 
Вилларибо и Виллабаджо.
*/
public class Solution {
    static ArrayList<Keyboard> keyboardOrchestra = new ArrayList<>();
    static ArrayList<Stringed> stringedOrchestra = new ArrayList<>();

    public static void main(String[] args) {
        createKeyboardOrchestra();
        createStringedOrchestra();
        playKeyboardOrchestra();
        playStringedOrchestra();
    }


    public static void createKeyboardOrchestra(){
        //напишите тут ваш код
        keyboardOrchestra.add(new Organ());
        keyboardOrchestra.add(new Piano());
        keyboardOrchestra.add(new Piano());
        keyboardOrchestra.add(new Piano());

    }

    public static void createStringedOrchestra(){
        //напишите тут ваш код
        stringedOrchestra.add(new Violin());
        stringedOrchestra.add(new Violin());
        stringedOrchestra.add(new Guitar());
    }

    public static void playKeyboardOrchestra(){
        //напишите тут ваш код
        for (var key : keyboardOrchestra) key.playKeys();
    }


    public static void playStringedOrchestra(){
        //напишите тут ваш код
        for (var strin : stringedOrchestra) strin.playStrings();
    }

}
