package com.java.algorithm.array;

import com.java.stdlib.StdOut;

import java.util.*;

public class GroupStudentByAge {

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void groupByAge(List<Person> people) {
        Map<Integer,Integer> ageToCount = new HashMap<>();

        for(Person p : people) {
            if(ageToCount.containsKey(p.age)) {
                ageToCount.put(p.age,ageToCount.get(p.age) + 1);
            } else {
                ageToCount.put(p.age,1);
            }
        }

        int offset = 0;
        Map<Integer,Integer> ageToOffset = new HashMap<>();
        for(Map.Entry<Integer,Integer> ac : ageToCount.entrySet()) {
            ageToOffset.put(ac.getKey(),offset);
            offset += ac.getValue();
        }

        while(!ageToOffset.isEmpty()) {
            Map.Entry<Integer,Integer> from = ageToOffset.entrySet().iterator().next();
            Integer toAge = people.get(from.getValue()).age;
            Integer toValue = ageToOffset.get(toAge);
            Collections.swap(people,from.getValue(),toValue);
            Integer count = ageToCount.get(toAge) - 1;
            ageToCount.put(toAge, count);
            if(count > 0) {
                ageToOffset.put(toAge, toValue + 1);
            } else {
                ageToOffset.remove(toAge);
            }

        }
    }

    public static void main(String[] args) {
        List<Person> A = new ArrayList<>();
        A.add(new Person("Mihir",10));
        A.add(new Person("Ojas",10));
        A.add(new Person("Kaavya",13));
        A.add(new Person("Hina",11));
        A.add(new Person("Rohit",13));
        A.add(new Person("Nita",11));
        A.add(new Person("Saloni",11));
        A.add(new Person("Shital",10));
        groupByAge(A);
        StdOut.println(A);

    }
}
