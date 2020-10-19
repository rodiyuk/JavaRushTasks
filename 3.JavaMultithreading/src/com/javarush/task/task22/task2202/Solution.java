package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        try{
        String[] strSplit = string.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            sb.append(strSplit[i]).append(" ");
        }
        return sb.toString().trim();
        } catch (Exception e){
            throw new TooShortStringException();
        }
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
