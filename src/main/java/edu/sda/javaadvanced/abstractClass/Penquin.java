package edu.sda.javaadvanced.abstractClass;

public class Penquin extends Bird {

    public Penquin(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("Pingwiny nie latają tylko pływają i człapią po lądzie");
    }
}
