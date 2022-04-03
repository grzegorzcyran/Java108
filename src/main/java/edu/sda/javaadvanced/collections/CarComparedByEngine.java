package edu.sda.javaadvanced.collections;

import java.util.Comparator;

/**
 * Klasa odpowiedzialna za sortowanie samochodów po wielkości silnika
 *
 * Założenia:
 * 1. Domyślnie samochody sortujemy po marce - do tego służy Comparable<Car> na klasie Car
 * 2. Mogą pojawić się potrzeby posortowania innego niż domyślne - do tego dokładamy właśnie osobne
 * klasy - dla każdego takiego algorytmu osobną
 * 3. Do "dodatkowego" sortowania używamy interfejsu Comparator<Car>
 */
public class CarComparedByEngine implements Comparator<Car> {

    /**
     * Interfejs Comparator wymusza nadpisanie metody compare
     * Ma też inne metody, ale są one domyślne, nie ma potrzeby ich nadpisywania - czyli można ale nie trzeba
     */

    @Override
    public int compare(Car car1, Car car2) {
        return car1.getEngine().compareTo(car2.getEngine());
    }
}
