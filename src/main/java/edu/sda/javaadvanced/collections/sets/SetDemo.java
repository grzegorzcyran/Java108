package edu.sda.javaadvanced.collections.sets;

import edu.sda.javaadvanced.collections.Car;

import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        Car car1 = new Car("Volvo", "2.0", 190);
        Car car2 = new Car("Ford", "1.6", 220);
        Car car3 = new Car("BMW", "3.2", 260);
        Car car4 = new Car("Fiat", "1.1", 160);

        /**
         * Set to interfejs
         * Set - przechowuje zestaw niepowtarzalnych obiektów
         * O niepowtarzalności decyduje zestaw hashCode - equals
         * Dostęp do dowolnego obiektu w Set jest bardzo szybki
         * Obiekty w Set są niepoukładane. Dodanie nowego obiektu może zmienić
         * kolejność np. przy wyświetlaniu.
         */

        /**
         * HashSet
         * Najbardziej podstawowa, najczęściej wykorzystywana implementacja
         */
        Set<Car> carSet = new HashSet<>();
        carSet.add(car1);
        carSet.add(car2);
        carSet.add(car3);
        carSet.add(car4);
        carSet.add(car2);
        carSet.add(car1);
        carSet.add(car4);

        for (Car car : carSet) {
            System.out.println(car.getName() + " " + car.getEngine() + " " + car.hashCode());
        }

        /**
         * LinkedHashSet pozwala na utrzymanie porządku elementów wg kolejności wstawiania
         */
        Set<Car> setSortedByEntering = new LinkedHashSet<>();
        setSortedByEntering.add(car1);
        setSortedByEntering.add(car2);
        setSortedByEntering.add(car3);
        setSortedByEntering.add(car4);
        System.out.println("\nWyświetlamy LinkedHashSet");
        for (Car car : setSortedByEntering) {
            System.out.println(car.getName());
        }

        /**
         * TreeSet będzie układał elementy wg zdefiniowanego mechanizmu sortowania
         * Zdefiniowanie mechanizmu sortowania obiektów polega na dodaniu na obiektcie
         * (w naszym przypadku Car) interfejsu Comparable i napisaniu metody compareTo
         */
        Set<Car> treeSet = new TreeSet<>();
        treeSet.add(car1);
        treeSet.add(car2);
        treeSet.add(car3);
        treeSet.add(car4);
        System.out.println("\nWyświetlamy treeSet:");
        for (Car car : treeSet) {
            System.out.println(car.getName());
        }

    }
}
