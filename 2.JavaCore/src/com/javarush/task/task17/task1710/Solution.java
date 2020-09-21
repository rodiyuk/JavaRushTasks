package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        String param = args[0];
        String name;
        Date bd;
        int id;
        Sex sex;
        Person person;
        SimpleDateFormat formatIn = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
        switch (param) {
            case "-c": {
                name = args[1];
                bd = formatIn.parse(args[3]);
                if (args[2].equals("м")) person = Person.createMale(name, bd);
                else person = Person.createFemale(name, bd);
                allPeople.add(person);
                System.out.println(allPeople.size()-1   );
            }
            break;
            case "-u": {
                name = args[2];
                bd = formatIn.parse(args[4]);
                id = Integer.parseInt(args[1]);
                sex = args[3].equals("м") ? Sex.MALE : Sex.FEMALE;
                person = allPeople.get(id);
                person.setName(name);
                person.setBirthDate(bd);
                person.setSex(sex);
                allPeople.set(id, person);
            }
            break;
            case "-d": {
                id = Integer.parseInt(args[1]);
                person = allPeople.get(id);
                person.setSex(null);
                person.setName(null);
                person.setBirthDate(null);
                allPeople.set(id, person);
            }
            break;
            case "-i": {
                id = Integer.parseInt(args[1]);
                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                person = allPeople.get(id);
                String sexStr = person.getSex() == Sex.MALE ? "м" : "ж";
                bd = person.getBirthDate();
                System.out.printf("%s %s %s", person.getName(), sexStr, format.format(bd));
            }
            break;
        }
    }
}
