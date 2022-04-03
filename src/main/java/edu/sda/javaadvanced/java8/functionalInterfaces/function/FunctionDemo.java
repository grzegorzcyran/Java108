package edu.sda.javaadvanced.java8.functionalInterfaces.function;

import edu.sda.javaadvanced.java8.functionalInterfaces.Traveller;

import java.util.function.Function;

public class FunctionDemo {

    public static void main(String[] args) {

        Traveller traveller1 = new Traveller("Jan", "Kowalski");
        Traveller traveller2 = new Traveller("Alina", "Nowak");
        Traveller traveller3 = new Traveller("Józef", "Nowak");
        Traveller traveller4 = new Traveller("Katarzyna", "Zawilska");

        /**
         * Function jest interfejsem funkcyjnym który przyjmuje obiekt i zwraca obiekt
         * w międzyczasie wykonując jakieś akcje i przekształcenia
         *
         * Używając interfejsu Function definiujemy jego metodę apply
         */

        Function<Traveller, String> extractSurname = (traveller) -> traveller.getSurName();
        Function<Traveller, Integer> surnameLength = (traveller) -> traveller.getSurName().length();

        Function<Traveller, Traveller> swapToDefault = (traveller) -> new Traveller("John", "Doe");

        Traveller swapper = swapToDefault.apply(traveller2);
        System.out.println(swapper.travellerInfo());
        System.out.println(extractSurname.apply(traveller4));
        System.out.println("Surname length for " + traveller1.travellerInfo() + " is " + surnameLength.apply(traveller1));
    }
}
