package edu.sda.javaadvanced.collections.demo;

import java.util.Comparator;

public class HumanBySurnameAndNameComparator implements Comparator<Human> {
    @Override
    public int compare(Human human1, Human human2) {
        //szeregowanie po nazwisku
        if(!human1.getSurname().equals(human2.getSurname())) {
            return human2.getSurname().compareTo(human1.getSurname());
        }

        //szeregowanie po imieniu
        return human2.getName().compareTo(human1.getName());

    }
}
