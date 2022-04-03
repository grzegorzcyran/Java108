package edu.sda.javaadvanced.java8.streams;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class OptionalExamples {
    public static void main(String[] args) {
        /**
         * Java8 wprowadziła Optional
         * czyli "opakowanie" na obiekt
         * gdzie w środku może być obiekt a może go nie być
         */

        Human human = new Human("Jan", "Kowalski", 33);
        Human nullHuman = null;

        System.out.println(human.getAge());
        //System.out.println(nullHuman.getAge()); - nullHuman jest Null stąd wywołanie na nim getAge kończy się NPE

        //metoda .of tworzy optionala na nie-nullowym obiekcie
        Optional<Human> optionalHuman = Optional.of(human);

        //metoda .ofNullable tworzy optionala na być-może-nullowym obiekcie
        Optional<Human> nullOptionalHuman = Optional.ofNullable(nullHuman);

        //stworzenie optionala z obiektu nullowego metodą of kończy się wyjątkiem
//        Optional<Human> anotherNullable = Optional.of(nullHuman);

        //od Javy 8 - sprawdzenie zawartości metodą isEmpty
        if(nullOptionalHuman.isEmpty()) {
            System.out.println("Null w optionalu!!!");
        }

        //od Javy 11 - kolejna metoda sprawdzania zawartości - pojawiła się bo najczęściej programiści
        //robili !isEmpty
        if(nullOptionalHuman.isPresent()) {
            System.out.println("Nie ma nulla w optionalu");
        }

        //pobranie zawartości Optionala
        //sugerowane jest aby najpierw sprawdzić czy jest co pobrać żeby nie skończyło sie na czerwono
        //Human stupid = nullOptionalHuman.get(); w środku null więc dostaniemy exception
        Human finalHuman = optionalHuman.get();

        LinkedList<Human> humanLinkedList = new LinkedList<>();
        humanLinkedList.add(human);
        humanLinkedList.add(human);
        humanLinkedList.add(human);
        humanLinkedList.add(human);

        System.out.println("======================");
        System.out.println("Wyświetlamy imię albo 'Nikt' jeśli różne od zadanego warunku");
        String found = humanLinkedList.stream()
                .map(Human::getName)
                .filter(each -> "Jan".equalsIgnoreCase(each))
                .findFirst()
                .orElse("Nikt");
        System.out.println("Co znaleziono: " + found);
        System.out.println("=======================");
        Optional<String> eventuallyFound = humanLinkedList.stream()
                .map(Human::getName)
                .filter(each -> each.equalsIgnoreCase("Jaś"))
                .findAny();
        if(eventuallyFound.isPresent()) {
            System.out.println("Znaleziono " + eventuallyFound.get());
        } else {
            System.out.println("Nic nie znaleziono bo Jaś to nie Jan");
        }
        System.out.println("=======================");
        System.out.println("Szukamy Jana i chcemy go pobrać do nowej zmiennej");
        Human jan = humanLinkedList.stream()
                .filter(each -> "Jan".equalsIgnoreCase(each.getName()))
                .findFirst()
                .orElse(new Human("John", "Doe", 22));
        System.out.println(jan.getHumanInfo());
        System.out.println("===============================");
        System.out.println("Żeby nie tworzyć dodatkowego obiektu, korzystamy z orElseGet zamiast orElse");
        Human innyJan = humanLinkedList.stream()
                .filter(each -> "Jan".equalsIgnoreCase(each.getName()))
                .findFirst()
                .orElseGet(() -> new Human("John", "Doe", 22));
        System.out.println("orElseGet przyjmuje suppliera więc wykona się tylko w przypadku wywołania");
        System.out.println(innyJan.getHumanInfo());
        System.out.println("===================================");
        System.out.println("A teraz Jasio szukany");
        Human jasio = humanLinkedList.stream()
                .filter(each -> "Jaś".equalsIgnoreCase(each.getName()))
                .findFirst()
                .orElseGet(() -> new Human("John", "Doe", 22));
        jasio.printHumanInfo();
        System.out.println("===================================");

    }
}
