package com.javarush.task.pro.task12.task1212;

/* 
Создаем свой список
*/
public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }
    public void print(){
        for (String s : elements) System.out.println(s);
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        capacity = (int) ((int)capacity * 1.5);
        String[] elements1 = new String[capacity];
        for (int i = 0; i < elements.length; i++) {
            elements1[i] = elements[i];
        }
        elements = elements1;
        //напишите тут ваш код
    }

}
