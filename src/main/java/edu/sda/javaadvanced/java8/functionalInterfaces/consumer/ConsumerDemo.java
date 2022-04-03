package edu.sda.javaadvanced.java8.functionalInterfaces.consumer;

import edu.sda.javaadvanced.java8.functionalInterfaces.Traveller;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {

        Traveller traveller1 = new Traveller("Jan", "Kowalski");
        Traveller traveller2 = new Traveller("Alina", "Nowak");

        /**
         * Consumer jest interfejsem funkcjyjnym który przyjmuje obiekt
         * jako parametr i nic nie zwraca
         * Definiując Consumera definiujemy jego abstrakcyjną metodę accept
         */

        Consumer<Traveller> printTravellerInfo = (traveller) -> {
            System.out.println("Printing traveler info");
            System.out.println(traveller.travellerInfo());
        };

        System.out.println("=======================");
        printTravellerInfo.accept(traveller1);
        System.out.println("=======================");
        printTravellerInfo.accept(traveller2);



    }
}
