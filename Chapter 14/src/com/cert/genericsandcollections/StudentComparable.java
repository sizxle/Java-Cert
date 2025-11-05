package com.cert.genericsandcollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentComparable implements Comparable<StudentComparable> {

    private Integer id;

    private String name;

    public StudentComparable(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compareTo(StudentComparable o) {
        return this.id-o.id;
    }

    @Override
    public String toString() {
        return "StudentComparable{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}

class Main{
    public static void main(String[] args){
        List<StudentComparable> students = new ArrayList<>();
        students.add(new StudentComparable(3, "Alice"));
        students.add(new StudentComparable(1, "Bob"));
        students.add(new StudentComparable(2, "Charlie"));

        Collections.sort(students); // Uses natural ordering (by ID)
        System.out.println(students);

    }
}
