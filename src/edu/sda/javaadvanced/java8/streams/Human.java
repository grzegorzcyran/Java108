package edu.sda.javaadvanced.java8.streams;

import java.math.BigDecimal;

public class Human implements Comparable<Human> {

    private String name;
    private String surName;
    private int age;

    public Human(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }

    public String humanInfo() {
        return new StringBuilder("Name: ").append(name)
                .append(", surname: ").append(surName)
                .append(", age: ").append(age)
                .toString();
    }

    public BigDecimal objectedAge() {
        return BigDecimal.valueOf(age);
    }

    @Override
    public int compareTo(Human human) {
        if(age != human.getAge()) {
            return age - human.getAge();
        }
        return humanInfo().compareTo(human.humanInfo());
    }
}
