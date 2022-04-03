package edu.sda.javaadvanced.interfaces;

public interface Gaming {
    void playGame(); // deklaracja metody, bez "ciała" czyli bez kodu jak ta metoda ma działać

    //w interfejsie można zdefiniować metodę od razu z kodem ale musi ona być domyślna albo statyczna
    default boolean isWinner() {
        return true;
    }
}
