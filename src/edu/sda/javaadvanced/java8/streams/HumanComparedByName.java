package edu.sda.javaadvanced.java8.streams;

import java.util.Comparator;

public class HumanComparedByName implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2) {
        return human1.getName().compareTo(human2.getName());
    }
}
