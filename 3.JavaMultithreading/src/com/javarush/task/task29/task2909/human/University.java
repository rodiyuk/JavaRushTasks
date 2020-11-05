package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        //TODO:
        for (Student student : students) {
            if (student.getAverageGrade() == averageGrade) return student;
        }
        return null;
    }


    public Student getStudentWithMaxAverageGrade() {
        //TODO:
        int index = 0;
        double max = students.get(0).getAverageGrade();
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() > max) {
                max = students.get(i).getAverageGrade();
                index = i;
            }
        }
        return students.get(index);
    }

    public Student getStudentWithMinAverageGrade() {
        //TODO:
        int index = 0;
        double min = students.get(0).getAverageGrade();
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverageGrade() < min) {
                min = students.get(i).getAverageGrade();
                index = i;
            }
        }
        return students.get(index);
    }
    public void expel(Student student){
        students.remove(student);
    }
}