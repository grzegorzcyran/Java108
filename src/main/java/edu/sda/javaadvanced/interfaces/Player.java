package edu.sda.javaadvanced.interfaces;

public class Player implements Gaming {

    String name;
    String game;

    public Player(String name) {
        this.name = name;
    }

    public void setGame(String game) {
        this.game = game;
    }

    @Override
    public void playGame() {
        System.out.println(name + " is playing " + game);
    }
}
