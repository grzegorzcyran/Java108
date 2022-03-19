package edu.sda.javaadvanced.collections.lists;

import edu.sda.javaadvanced.collections.Car;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        Car car1 = new Car("Volvo", "2.0", 190);
        Car car2 = new Car("Ford", "1.6", 220);
        Car car3 = new Car("BMW", "3.2", 260);
        Car car4 = new Car("Fiat", "1.1", 160);

        /**
         * Definicja kolekcji przed Javą 1.7:
         */
        List<Car> oldStyleList = new ArrayList<Car>();

        /**
         * Definicja teraz
         */
        List<Car> carList = new ArrayList<>();

        /**
         * List jest interfejsem
         * Zawiera ogólną definicję listy. Charakteryzuje się tym że:
         *  - elementy są ułożone po kolei
         *  - możemy dostać się do dowolnego elementu posługując się indeksem
         *  - może zawierać duplikaty (czyli wielokrotnie ten sam obiekt)
         */

        /**
         * ArrayList jest najprostszą, najczęściej stosowaną implementacją listy
         * Ma domyślny rozmiar początkowy (podobnie do tabeli)
         * Po dodaniu określonej liczby elementów, jest automatycznie powiększana
         * Jest ułożona w kolejnych komórkach pamięci (jak tablica)
         * Bardzo szybko można wybrać dowolny element z tablicy
         * Usuwanie elementów z tablicy jest długotrwałe
         * [x][x][x][x][x][x][x][x][x][x][x][x]
         */

        /**
         * LinkedList jest listą utworzoną na zasadzie węzłów "poprzednik - następnik"
         * Nie jest przechowywana w spójnym miejscu w pamięci
         * Dodanie dowolnego elementu w dowolne miejsce jest szybkie
         * Usunięcie elementu z dowolnego miejsca jest szybkie
         * Im większa lista tym dłuższy czas potrzebny na wyszukanie konkretnego elementu po indeksie
         * [x]-[x][x]--------[x]--[x]---[x]--[x][x]
         */

        carList.add(car1);
        carList.add(car2);
        carList.add(car1);
        carList.add(car3);
        carList.add(car4);
        carList.add(car1);

        System.out.println("Drukujemy zawartość arrayListy, sprawdzimy czy są duplikaty");
        for (Car car : carList) {
            System.out.println(car);
        }

        carList.remove(car1); //usuniemy pierwsze wystąpienie car1
        System.out.println("\nDrukujemy zawartość arrayListy, sprawdzimy czy usunęło pierwszy car1 (volvo)");
        for (Car car : carList) {
            System.out.println(car);
        }

        carList.remove(3);
        System.out.println("\nDrukujemy zawartość arrayListy, sprawdzimy czy usunęło fiata");
        for (Car car : carList) {
            System.out.println(car);
        }

        carList.add(1, car4);
        System.out.println("\nDrukujemy zawartość arrayListy, ponownie dodajemy fiata ale wcześniej");
        for (Car car : carList) {
            System.out.println(car);
        }

        List<Car> carsToRemove = new ArrayList<>();
        carsToRemove.add(car4);
        carsToRemove.add(car3);
        carList.add(car4);
        carList.add(car4);
        carList.add(car4);
        carList.removeAll(carsToRemove);
        System.out.println("\nDrukujemy zawartość arrayListy, po usunięciu grupy");
        for (Car car : carList) {
            System.out.println(car);
        }


    }
}
