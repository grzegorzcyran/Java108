package edu.sda.javaadvanced.abstractClass;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void move();

    public String getName() {
        return name;
    }
}
