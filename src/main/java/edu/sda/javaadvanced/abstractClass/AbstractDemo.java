package edu.sda.javaadvanced.abstractClass;

public class AbstractDemo {
    public static void main(String[] args) {


        /**
         * Nie da się bezpośrednio zrobić obiektu z klasy abstrakcyjnej
         * chyba że przy definicji obiektu od razu napiszemy "jednorazowe" ciało klasy
         */
//        Animal animal = new Animal() {
//            //tu powinno być "jednorazowe" ciało klasy
//        }

        Bird bird1 = new Bird("Jastrząb");
        bird1.move();

        Bee bee = new Bee("Maja");
        bee.hibernate();

        Penquin penquin = new Penquin("Skipper");
        penquin.move();

    }
}
