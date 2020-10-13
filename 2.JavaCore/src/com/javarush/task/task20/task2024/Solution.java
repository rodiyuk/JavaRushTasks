package com.javarush.task.task20.task2024;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/
public class Solution implements Serializable{
    int node;
    List<Solution> edges = new LinkedList<>();
    ObjectOutputStream outputStream;

    {
        try {
            outputStream = new ObjectOutputStream(new ByteArrayOutputStream());
            outputStream.writeObject(node);
            outputStream.writeObject(edges);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

    }
}
