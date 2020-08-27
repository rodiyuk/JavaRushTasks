package com.javarush.task.pro.task13.task1316;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        JavarushQuest[] quests = JavarushQuest.values();
        for (int i = 0; i < quests.length; i++) {
            System.out.println(quests[i].ordinal());
        }
    }
}
