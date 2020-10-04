package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("in.txt");
            InputStream inputStream = new FileInputStream("in.txt");

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);
            user.setFirstName("Sometging");
            user.setFirstName("Anybody");
            user.setBirthDate(new Date());
            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            System.out.println(javaRush.equals(loadedObject));
            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write(users.size() + "\n");
            if (users.size() != 0) {
                for (User user : users) {
                    writer.write(user.getFirstName() + "\n");
                    writer.write(user.getLastName() + "\n");
                    writer.write(user.getBirthDate().getTime() + "\n");
                    writer.write(user.getCountry().getDisplayName() + "\n");
                    writer.write(user.isMale() + "\n");
                }
            } else writer.write("null");
            writer.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            int size = Integer.parseInt(reader.readLine());
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    String country = reader.readLine();
                    if (country.equals("Russia")) {
                        user.setCountry(User.Country.RUSSIA);
                    } else if (country.equals("Ukraine")) {
                        user.setCountry(User.Country.UKRAINE);
                    } else user.setCountry(User.Country.OTHER);

                    user.setMale(Boolean.parseBoolean(reader.readLine()));
                    users.add(user);
                }

            } else System.out.println("Список пустой");;
            reader.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
