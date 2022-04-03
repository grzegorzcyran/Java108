package edu.sda.javaadvanced.java8.streams;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamExercises {
    public static void main(String[] args) {
        class HumanDTO {
            String name;
            String surname;

            public HumanDTO(String name, String surname) {
                this.name = name;
                this.surname = surname;
            }

            public String humanSummary() {
                return new StringBuilder("DTO: name=").append(name)
                        .append(", surname=").append(surname)
                        .toString();
            }
        }

        List<Human> people = new ArrayList<>();
        people.add(new Human("Jan", "Kowalski", 22));
        people.add(new Human("Marek", "Kowalski", 33));
        people.add(new Human("Paweł", "Kowalski", 44));
        people.add(new Human("Marian", "Nowak", 15));
        people.add(new Human("Paweł", "Wiewiór", 55));
        people.add(new Human("Anna", "Jalewska", 25));

        Set<Human> peopleSet = new HashSet<>();
        peopleSet.add(new Human("Agnieszka", "Zawilska", 25));
        peopleSet.add(new Human("Renata", "Zając", 33));
        peopleSet.add(new Human("Maria", "Rolecka", 57));
        peopleSet.add(new Human("Zofia", "Papciuch", 44));
        peopleSet.add(new Human("Edyta", "Jachimczak", 38));

        //1. Złączyć kolekcje i wyświetlić imiona wszystkich ludzi
        //2. Wybrać wszystkich którzy nazywają się Paweł, Renata albo Agnieszka i wyświetlić
        //3. Wyświetlić ludzi posortowanych po nazwisku od Z do A
        //4. Wyświetlić sumę wieku ludzi ale tylko tych starszych niż 35 lat
        //5. Wyświetlić złączone imiona ludzi, między nimi przecinek i spacja ale tylko ludzi młodszych niż 40
    }
}
