package edu.sda.javaadvanced.java8.functionalInterfaces;

public class Traveller implements Movable {

    private String name;
    private String surName;

    public Traveller(String name, String surName) {
        System.out.println("Tworzymy nowy obiekt z imieniem: " + name + " i nazwiskiem: " + surName);
        this.name = name;
        this.surName = surName;
    }

    public String getSurName() {
        return surName;
    }

    //metoda abstrakcyjna w interfejsie, MUSIMY ją nadpisać
    @Override
    public String move() {
        return name + " " + surName + " " + "is travelling";
    }

    //Metoda domyślna w interfejsie, MOŻEMY ale NIE MUSIMY jej nadpisywać
    @Override
    public String moveWith(String partner) {
        return move() + " but this time with " + partner;
    }

    public String travellerInfo() {
        return name + " " + surName;
    }
}
