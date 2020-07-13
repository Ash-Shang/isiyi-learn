package com.isiyi.compare;

import lombok.Data;

@Data
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    @Override
    public int compareTo(Student o) {
        return this.getAge() - o.getAge();
    }
}
