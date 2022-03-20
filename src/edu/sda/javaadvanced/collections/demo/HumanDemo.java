package edu.sda.javaadvanced.collections.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HumanDemo {
    public static void main(String[] args) {
        Human human1 = new Human("Jan", "Muzykant", 12, Gender.MALE);
        Human human2 = new Human("Wolfgang", "Mozart", 33, Gender.MALE);
        Human human3 = new Human("Edyta", "Geppert", 58, Gender.FEMALE);
        Human human4 = new Human("Ewa", "Bem", 62, Gender.FEMALE);

        List<Human> listOfHuman = new ArrayList<>();
        listOfHuman.add(human1);
        listOfHuman.add(human2);
        listOfHuman.add(human3);
        listOfHuman.add(human4);

        Set<Human> setOfPeople = new HashSet<>();
        setOfPeople.add(human1);
        setOfPeople.add(human2);
        setOfPeople.add(human3);
        setOfPeople.add(human4);
    }
}
