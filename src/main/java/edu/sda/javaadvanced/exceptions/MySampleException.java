package edu.sda.javaadvanced.exceptions;

/**
 * Definiowanie własnego wyjątku
 */

public class MySampleException extends IllegalArgumentException {

    public MySampleException(String s) {
        super(s);
        System.out.println("Wyjątek przechodzi przez konstruktor z parametrem");
    }

    public MySampleException() {
        System.out.println("Wyjątek przechodzi przez konstruktor bezparametrowy");
    }
}
