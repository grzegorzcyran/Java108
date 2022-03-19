package edu.sda.javaadvanced.collections;

/**
 * Klasa taka jak ta poniżej : z konstruktorem ale bez setterów
 * to klasa niemutowalna (immutable) - bardzo wskazana przy programowaniu w wątkach
 * bo z każdego miejsca odwołanie do obiektu zwróci to samo, nie ma możliwości
 * zmiany pól klasy
 */
public class Car {

    private final String name;
    private final String engine;
    private final int maxSpeed;

    public Car(String name, String engine, int maxSpeed) {
        this.name = name;
        this.engine = engine;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public String getEngine() {
        return engine;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", engine='" + engine + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
