package com.javarush.task.task19.task1904;

/*
И еще один адаптер
*/

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] s = fileScanner.nextLine().split(" ");
            Date bd = new Date();
            bd.setYear(Integer.parseInt(s[5]) - 1900);
            bd.setMonth(Integer.parseInt(s[4])-1);
            bd.setDate(Integer.parseInt(s[3]));
            Person person = new Person(s[1], s[2], s[0], bd);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
