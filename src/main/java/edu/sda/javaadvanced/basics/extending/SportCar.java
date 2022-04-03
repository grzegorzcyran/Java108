package edu.sda.javaadvanced.basics.extending;

/**
 * Klasa SportCar dziedziczy po Car czyli korzysta z funkcjonalności
 * dostępnych dla klasy Car a dodatkowo definiuje własne
 *
 */
public class SportCar extends Car {
    private int accelerationTo100;

    public SportCar(int accelerationTo100) {
        //tutaj też jest konstruktor nadklasy, ten bezparametrowy
        System.out.println("SportCar konstruktor z 1 parametrem");
        this.accelerationTo100 = accelerationTo100;
    }

    /**
     * Słowo kluczowe super oznacza wywołanie konstruktora nadklasy - tego który ma odpowiednie
     * parametry
     * !!!UWAGA!!! wywołanie konstruktora nadklasy MUSI być pierwszą instrukcją w konstruktorze
     * klasy pochodnej
     */
    public SportCar(String name, String color, int accelerationTo100) {
        super(name, color);
        System.out.println("SportCar konstruktor z 3 parametrami");
        this.accelerationTo100 = accelerationTo100;
    }

    public int getAccelerationTo100() {
        return accelerationTo100;
    }
}
