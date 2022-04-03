package edu.sda.javaadvanced.collections.demo;

import java.util.Comparator;

public class HumanByGenderAndAgeComparator implements Comparator<Human> {

    @Override
    public int compare(Human human1, Human human2) {
        if(human1.getGender() != human2.getGender()) {
            return human1.getGender().getIndex() - human2.getGender().getIndex();
        }

        return human2.getAge() - human1.getAge();
    }
}
