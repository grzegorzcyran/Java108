package edu.sda.javaadvanced.abstractClass;

public class Bee extends Worm {

    public Bee(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println("Pszczoła lata");
    }

    @Override
    public void hibernate() {
        System.out.println("Pszczoła hibernuje w zimie");
    }
}
