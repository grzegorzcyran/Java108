package edu.sda.javaadvanced.basics.extending;

/**
 * Klasa która nie dziedziczy jawnie po żadnej innej klasie
 * Dziedziczy w sposób niejawny po klasie java.lang.Objekt
 * Dzięki temu w każdej klasie mamy dostępne metody odziedziczone z Object:
 * toString(), equals(), hashCode(), ...
 */

public class Car {
    private String name;
    String color;

    //np. Hibernate wymaga w obiektach konstruktora bezparametrowego
    public Car() {
        System.out.println("Konstruktor bezparametrowy klasy Car");
    }

    public Car(String name, String color) {
        System.out.println("Konstruktor z parametrami klasy Car");
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
