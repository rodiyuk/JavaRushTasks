package com.javarush.task.pro.task05.task0505;

import java.util.Scanner;

/* 
Reverse
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Scanner sc = new Scanner(System.in);
        int n;
        while(true){
            if((n = sc.nextInt()) > 0) {
                break;
            } else System.out.println("Enter again, please");
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        if(n%2==0){
            for (int i = n-1; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        } else {
            for (int i = 0; i < n; i++) {
                System.out.println(arr[i]);
            }
        }
    }

}
