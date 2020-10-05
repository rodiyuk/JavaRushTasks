package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
    public static void main(String[] args) throws IOException {
        FileOutputStream outputStream = new FileOutputStream("in.txt");
        FileInputStream inputStream = new FileInputStream("in.txt");
        Solution savedObject = new Solution(5);
        savedObject.save(outputStream);
        Solution loadedObject = new Solution(15);
        loadedObject.load(inputStream);
        System.out.println(savedObject.string.equals(loadedObject.string));
        System.out.println(new Solution(4));
    }
    public void save(OutputStream outputStream) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new PrintWriter(outputStream));
        bufferedWriter.write(string);
        bufferedWriter.close();
    }

    public void load(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        string = bufferedReader.readLine();
        bufferedReader.close();
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
