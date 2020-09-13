package com.javarush.task.task14.task1419;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }try {
            int[] arr = new int[2];
            arr[2] = 15;
        } catch (Exception e) {
            exceptions.add(e);
        } try {
            String s = null;
            System.out.println(s.length());
        } catch (Exception e) {
            exceptions.add(e);
        } try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\sss.rrs"));
        } catch (Exception e) {
            exceptions.add(e);
        } try {
            Integer.parseInt("ssss");
        } catch (Exception e) {
            exceptions.add(e);
        } try {
            int[] arr = new int[-5];
        } catch (Exception e) {
            exceptions.add(e);
        } try {
            String s = "asdf";
            s.substring(5);
        } catch (Exception e) {
            exceptions.add(e);
        } try {
            ArrayList<Object> list = new ArrayList(1);
            list.get(3);
        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new ClassCastException());
        exceptions.add(new NoSuchFieldException());


        //напишите тут ваш код

    }
}
