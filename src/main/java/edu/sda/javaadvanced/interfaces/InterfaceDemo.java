package edu.sda.javaadvanced.interfaces;

public class InterfaceDemo {
    public static void main(String[] args) {
        User user = new User("Wojtek", "Wiedźmin 3", "HTML");
        user.playGame();
        user.code("");
        user.code("HTML + CSS");

        System.out.println("=====================");
        Player player = new Player("Ania");
        player.setGame("RDR2");
        player.playGame();
        System.out.println("=====================");

        Programmer programmer = new Programmer("Janek");
        programmer.code("HTML");
        programmer.codeOOP("Java");


    }
}
