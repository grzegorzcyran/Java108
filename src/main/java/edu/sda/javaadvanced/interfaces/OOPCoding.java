package edu.sda.javaadvanced.interfaces;

/**
 * Jeden interfejs może dziedziczyć po drugim
 * Wtedy obiekt "implementujący" ten interfejs końcowy
 * musi obsłużyć wszystkie deklaracje metod z interfejsów z drzewa dziedziczenia
 */

public interface OOPCoding extends Coding {
    void codeOOP(String language);
}
