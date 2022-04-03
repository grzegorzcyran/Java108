package edu.sda.javaadvanced.basics.extending;

public class TruckCar extends Car {
    private int capacity;

    public TruckCar(int capacity) {
        //tu tak naprawdę jest wywoływane super();
        System.out.println("Konstruktor klasy TruckCar");
        this.capacity = capacity;
    }
}
