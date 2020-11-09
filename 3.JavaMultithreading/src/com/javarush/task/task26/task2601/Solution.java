package com.javarush.task.task26.task2601;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
//        Integer[] array = {13, 8,15,5,17,11};
//        System.out.println(Arrays.toString(sort(array)));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int mediana;
        if (array.length % 2 == 0) {
            mediana = (array[array.length / 2] + array[array.length / 2 - 1]) / 2;
        } else mediana = array[array.length / 2];
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int dest = (int) Math.abs(list.get(i) - mediana);
            list1.add(dest);
        }
        int k = 0;
        for (int i = 0; i < list.size(); ) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = i; j < list1.size(); j++) {
                Integer integer = list1.get(j);
                if (integer < min) {
                    min = integer;
                    index = j;
                }
            }
            array[k++] = list.get(index);
            list1.remove((Integer)min);
            list.remove(index);
        }
        return array;
    }
}
