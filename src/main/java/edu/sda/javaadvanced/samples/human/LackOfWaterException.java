package edu.sda.javaadvanced.samples.human;

public class LackOfWaterException extends IllegalArgumentException{

    public LackOfWaterException(String s) {
        super(s);
        System.out.println("Brak wody!!! bo pozycja : " + s);
    }
}
