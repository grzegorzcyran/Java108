package edu.sda.javaadvanced.java8.functionalInterfaces;

/**
 * Anotacja FunctionalInterface określa że interfejs może mieć dokładnie jedną
 * metodę abstrakcyjną (bez ciała)
 * Jeśli w interfejsie występuje więcej metod to muszą one być:
 *  - domyślne lub
 *  - prywatne lub
 *  - statyczne
 */

@FunctionalInterface
public interface Movable {

    String move();

//    String slowMove(); - na FunctionalInterface nie przejdzie

    default String moveWith(String partner) {
        return move() + " with " + partner;
    }


}
