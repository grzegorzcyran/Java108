package edu.sda.javaadvanced.java8.functionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfacesExcersises {
    public static void main(String[] args) {
        /**
         * No podstawie klasy Bird
         * dołożyć :
         * implementację Predicate sprawdzającą czy ptak to gołąb
         * implementację Predicate sprawdzającą czy nazwa ptaka jest krótsza niż 10 znaków
         *
         * implementację Suppliera zwracającą Kruka
         * wykorzystać ją wyświetlając (jakoś, np jeśli któryś istniejący ptak to orzeł)
         *
         * implementację Consumera wyświetlającą: na jaką literę zaczyna się nazwa ptaka, długość nazwy ptaka
         *
         * implementację Function przyjmującą ptaka, zwracającą String z jego nazwą, długością nazwy i informacją
         * o tym na jaką literę zaczyna się nazwa
         */

        Bird pigeon = new Bird("pigeon");
        Bird falcon = new Bird("falcon");
        Bird raven = new Bird("raven");
        Bird eagle = new Bird("eagle");
        Bird longNameBird = new Bird("Bird with long name");

        //implementację Predicate sprawdzającą czy ptak to gołąb
        Predicate<Bird> isPigeon = (bird) -> "pigeon".equalsIgnoreCase(bird.getBirdName());
        Predicate<Bird> isPigeon2 = (bird) -> bird.getBirdName().toLowerCase().startsWith("pigeon");
        //implementację Predicate sprawdzającą czy nazwa ptaka jest krótsza niż 10 znaków
        Predicate<Bird> isShortNameBird = (bird) -> bird.getBirdName().length() < 10;

        System.out.println("===========================");
        if(isPigeon.test(pigeon)) {
            System.out.println("Bird " + pigeon.getBirdName() + " is a pigeon");
        }
        if(isShortNameBird.test(longNameBird)) {
            System.out.println("Sth's wrong");
        }
        System.out.println("===========================");
        //implementację Suppliera zwracającą Kruka
        Supplier<Bird> ravenSupply = () -> raven;
        Supplier<Bird> ravenSupply2 = () -> new Bird("Raven");
        //wykorzystać ją wyświetlając (jakoś, np jeśli któryś istniejący ptak to orzeł)
        if("eagle".equalsIgnoreCase(eagle.getBirdName())) {
            System.out.println("Eagle asked so raven to support: " + ravenSupply2.get().getBirdName());
        }
        System.out.println("===========================");
        //implementację Consumera wyświetlającą: na jaką literę zaczyna się nazwa ptaka, długość nazwy ptaka
        Consumer<Bird> birdSpecialInfo = (bird) -> {
            StringBuilder result = new StringBuilder()
                    .append("First letter: ")
                    .append(bird.getBirdName().charAt(0))
                    .append(", bird length: ")
                    .append(bird.getBirdName().length());
            System.out.println(result);
        };

        birdSpecialInfo.accept(falcon);
        System.out.println("===========================");
        //implementację Function przyjmującą ptaka, zwracającą String z jego nazwą, długością nazwy i informacją
        //o tym na jaką literę zaczyna się nazwa
        Function<Bird, String> birdDetailedInfo = (bird) -> {
             return new StringBuilder(bird.getBirdName())
                    .append(", name length: ")
                    .append(bird.getBirdName().length())
                    .append(", first letter: ")
                    .append(bird.getBirdName().charAt(0))
                    .toString();
        };

        System.out.println(birdDetailedInfo.apply(eagle));
        System.out.println("===========================");
    }
}
