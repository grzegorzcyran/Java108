package edu.sda.javaadvanced.abstractClass;

/**
 * Jedna klasa abstrakcyjna może dziedziczyć po innej klasie abstrakcyjnej
 */
public abstract class Worm extends Animal {

    public Worm(String name) {
        super(name);
    }

    public abstract void hibernate();
}
