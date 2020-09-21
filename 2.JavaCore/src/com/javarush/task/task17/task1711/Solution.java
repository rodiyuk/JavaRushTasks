package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String name;
        Date bd;
        int id;
        Sex sex;
        Person person;
        SimpleDateFormat formatIn = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    int i = (args.length - 1) / 3;
                    for (int j = 0, k = 0; j < i; j++, k += 3) {
                        name = args[1 + k];
                        bd = formatIn.parse(args[3 + k]);
                        if (args[2 + k].equals("м")) person = Person.createMale(name, bd);
                        else person = Person.createFemale(name, bd);
                        allPeople.add(person);
                        System.out.println(allPeople.size() - 1);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    int i = (args.length - 1) / 4;
                    for (int j = 0, k = 0; j < i; j++, k += 4) {
                        name = args[2 + k];
                        bd = formatIn.parse(args[4 + k]);
                        id = Integer.parseInt(args[1 + k]);
                        sex = args[3 + k].equals("м") ? Sex.MALE : Sex.FEMALE;
                        person = allPeople.get(id);
                        person.setName(name);
                        person.setBirthDate(bd);
                        person.setSex(sex);
                        allPeople.set(id, person);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    int i = args.length - 1;
                    for (int j = 0; j < i; j++) {
                        id = Integer.parseInt(args[1 + j]);
                        person = allPeople.get(id);
                        person.setSex(null);
                        person.setName(null);
                        person.setBirthDate(null);
                        allPeople.set(id, person);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    int i = args.length - 1;
                    for (int j = 0; j < i; j++) {
                        id = Integer.parseInt(args[1 + j]);
                        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                        person = allPeople.get(id);
                        String sexStr = person.getSex() == Sex.MALE ? "м" : "ж";
                        bd = person.getBirthDate();
                        System.out.printf("%s %s %s\n", person.getName(), sexStr, format.format(bd));
                    }
                }
                break;
        }
    }
}