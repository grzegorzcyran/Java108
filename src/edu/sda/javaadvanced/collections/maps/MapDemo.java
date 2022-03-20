package edu.sda.javaadvanced.collections.maps;

import edu.sda.javaadvanced.collections.Car;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        Car car1 = new Car("Volvo", "2.0", 190);
        Car car2 = new Car("Ford", "1.6", 220);
        Car car3 = new Car("BMW", "3.2", 260);
        Car car4 = new Car("Fiat", "1.1", 160);

        /**
         * Mapa - struktura przechowująca dane w formacie Klucz-Wartość
         *
         * Map<K,V> - zakłada że klucze muszą być unikalne ale wartości już niekoniecznie
         * czyli - klucze są niepowtarzalne
         * ale dla różnych kluczy mogą wystąpić te same wartości
         *
         * Map to interfejs, komkretne implementacje to HashMap, LinkedHashMap, TreeMap
         * - nazwy odnoszą się do faktu że klucze mapy przechowywane są jako SET
         */

        Map<String, Car> carMap = new HashMap<>();
        carMap.put(car1.getName(), car1);
        carMap.put(car2.getName(), car2);
        carMap.put(car3.getName(), car3);
        carMap.put(car4.getName(), car4);
        carMap.put("Inny klucz", car1);
        carMap.put("Jeszcze inny klucz", car3);
        System.out.println("Wyświetlamy wartości mapy - czyli samochody, użyjemy getCarInfo");
        System.out.println("Iterowanie po kluczach");
        for (String carName : carMap.keySet()) {
            System.out.println("\nNazwa samochodu: " + carName);
            System.out.println("Info o samochchodzie: " + carMap.get(carName).getCarInfo()); //get pobiera wartośc spod wskazanego klucza
        }

        grubaKrecha();
        System.out.println("Iterowanie po wartościach");
        for (Car car : carMap.values()) {
            System.out.println("Kolejny raz info: " + car.getCarInfo());

        }

        grubaKrecha();
        System.out.println("Iterowanie po wpisach");
        //Wpis to zestaw <klucz, wartość>.
        for (Map.Entry<String, Car> entry : carMap.entrySet()) {
            System.out.println("Klucz: " + entry.getKey());
            System.out.println("Wartość: " + entry.getValue().getCarInfo());
        }

        grubaKrecha();
        //Podmiana elementu pod wskazanym kluczem
        carMap.put(car1.getName(), car2);
        System.out.println("Iterowanie po kluczach po wprowadzeniu duplikatu wartości");
        for (String carName : carMap.keySet()) {
            System.out.println("\nNazwa samochodu: " + carName);
            System.out.println("Info o samochchodzie: " + carMap.get(carName).getCarInfo()); //get pobiera wartośc spod wskazanego klucza
        }

        grubaKrecha();
        System.out.println("Czy mapa pusta? " + carMap.isEmpty());
        System.out.println("Rozmiar mapy? " + carMap.size());

        grubaKrecha();
        carMap.remove(car3.getName());
        System.out.println("Iterowanie po kluczach po usunięciu jednego elementu");
        for (String carName : carMap.keySet()) {
            System.out.println("\nNazwa samochodu: " + carName);
            System.out.println("Info o samochchodzie: " + carMap.get(carName).getCarInfo()); //get pobiera wartośc spod wskazanego klucza
        }
    }

    private static void grubaKrecha() {
        System.out.println("===================");
        System.out.println("===================");
    }
}
