package edu.sda.javaadvanced.interfaces;

/**
 * Klasa może rozszerzać więcej niż 1 interfejs
 */

public class User implements Coding, Gaming {
    String name;
    String game;
    String language;

    public User(String name, String game, String language) {
        this.name = name;
        this.game = game;
        this.language = language;
    }

    @Override
    public void code(String language) {
        if(language.isEmpty()) {
            System.out.println(name + "is coding in " + this.language);
        } else {
            System.out.println(name + " is coding in " + language);
        }
    }

    @Override
    public void playGame() {
        System.out.println(name + " is playing " + game);
    }
}
