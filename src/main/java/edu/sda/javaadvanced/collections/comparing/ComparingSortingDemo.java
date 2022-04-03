package edu.sda.javaadvanced.collections.comparing;

import edu.sda.javaadvanced.collections.Car;
import edu.sda.javaadvanced.collections.CarComparedByEngine;
import edu.sda.javaadvanced.collections.CarComparedByMaxSpeedAndEngine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparingSortingDemo {

    public static void main(String[] args) {

        Car car1 = new Car("Volvo", "2.0", 190);
        Car car2 = new Car("Ford", "1.6", 220);
        Car car3 = new Car("BMW", "3.2", 260);
        Car car4 = new Car("Fiat", "1.1", 160);

        List<Car> carList = new ArrayList<>();
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);

        grubaKrecha();
        printList(carList);
        grubaKrecha();
        System.out.println("A teraz posortujemy dane po nazwie samochodu");
        /**
         * Metoda Collections.sort wykorzystuje domyślny komparator klasy
         * czyli wymaga żeby na klasie był Comparable i zaimplementowana metoda compareTo
         */
        Collections.sort(carList);
        printList(carList);

        grubaKrecha();
        /**
         * Możemy wykorzystać też zewnętrzny komparator
         */
        //Collections.sort(carList, new CarComparedByEngine());
        CarComparedByEngine externalComparator = new CarComparedByEngine();
        Collections.sort(carList, externalComparator);
        printList(carList);

        grubaKrecha();
        System.out.println("Wypisujemy posortowane po prędkości a następnie po silniku");
        Car car5 = new Car("Seat", "1.7", 220);
        carList.add(car5);
        Collections.sort(carList, new CarComparedByMaxSpeedAndEngine());
        printList(carList);
    }

    private static void printList(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getCarInfo());
        }
    }

    private static void grubaKrecha() {
        System.out.println("===================");
        System.out.println("===================");
    }
}
