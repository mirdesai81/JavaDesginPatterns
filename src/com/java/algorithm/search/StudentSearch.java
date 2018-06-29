package com.java.algorithm.search;

import com.java.stdlib.StdOut;

import java.util.*;

public class StudentSearch {

    public static class Student {
        public String name;
        public Double gpa;

        public Student(String name, Double gpa) {
            this.name = name;
            this.gpa = gpa;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getGpa() {
            return gpa;
        }

        public void setGpa(Double gpa) {
            this.gpa = gpa;
        }
    }

    private static final Comparator<Student> compGPA = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if(o1.gpa != o2.gpa) {
                return Double.compare(o1.gpa,o2.gpa);
            }

            return o1.name.compareTo(o2.name);

        }
    };

    public static boolean searchStudent(List<Student> students,Student target,Comparator<Student> compGPA) {
        return Collections.binarySearch(students,target,compGPA) >= 0;
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(Arrays.asList(new Student("john",3.45),
                new Student("foo",3.12),
                new Student("bar", 3.05)));

        StdOut.println(searchStudent(students,new Student("foo",3.12),compGPA));
    }
}
