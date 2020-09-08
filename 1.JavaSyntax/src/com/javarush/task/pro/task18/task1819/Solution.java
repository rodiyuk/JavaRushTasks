package com.javarush.task.pro.task18.task1819;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/* 
Как быть если в списке есть элемент null
*/

public class Solution {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "first", "second", null, "fourth", "fifth");

        printList(strings);
    }

    public static void printList(List<String> list) {
        //напишите тут ваш код
            System.out.println(Optional.ofNullable(list.get(0)).orElse("Этот элемент равен null"));
            System.out.println(Optional.ofNullable(list.get(1)).orElse("Этот элемент равен null"));
            System.out.println(Optional.ofNullable(list.get(2)).orElse("Этот элемент равен null"));
            System.out.println(Optional.ofNullable(list.get(3)).orElse("Этот элемент равен null"));
            System.out.println(Optional.ofNullable(list.get(4)).orElse("Этот элемент равен null"));
      /*  Optional<String> optional = Optional.ofNullable(list.toString());
        System.out.println(optional.orElse("Этот элемент равен null"));*/
    }
}
