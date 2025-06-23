/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Student {
    private int rollno;
    private String name;
    private int age;

    public Student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }

    public int getRollno() {
        return rollno;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}