package edu.sda.javaadvanced.java8.functionalInterfaces;

import java.util.ArrayList;
import java.util.List;

public class TestFunctionalInterfaces {

    public static void main(String[] args) {

        /**
         * Zdefiniowanie:
         * Movable human = new Traveller
         * to tzw. polimorfizm czyli: każdy Traveller jest Movable
         * NIE KAŻDY Movable to Traveller
         */
        Movable human = new Traveller("Jan", "Kowalski");
        Movable eagle = new Bird("White Eagle");

        System.out.println("=================");
        System.out.println(human.move());
        System.out.println(eagle.move());
        System.out.println("==================");
        System.out.println(human.moveWith("Marian Nowak"));
        System.out.println(eagle.moveWith("Falcon"));
        System.out.println("==================");

        /**
         * Po co jest polimorfizm:
         * bo możemy dzięki temu wrzucić różne de facto obiekty
         * do jednego "worka" i potraktować je tak samo
         */
        List<Movable> allInMove = new ArrayList<>();
        allInMove.add(human);
        allInMove.add(eagle);
        for (Movable movable : allInMove) {
            System.out.println(movable.move());
        }

        System.out.println("======================");
        System.out.println("======================");
        System.out.println("Polimorfizm");
        Movable anotherHuman = new Traveller("Mariola", "Dębska");
        allInMove.add(anotherHuman);
        Traveller yetAnotherInMove = new Traveller("Scott", "Jurek");
        allInMove.add(yetAnotherInMove);

        //żeby wywołać metodę travellerInfo, robimy rzutowanie
        System.out.println(((Traveller) anotherHuman).travellerInfo());


        System.out.println("======================");
        System.out.println("======================");
        System.out.println("======================");
        List<Traveller> travellers = new ArrayList<>();
        /**
         * poniżej mówimy "drogi kompilatorze, wiem że human jest powołany do życia jako Movable
         * ale uwierz mi na słowo, to jest Traveller i tak go potraktuj"
         * kompilator próbuje uwierzyć i "transformuje" Movable Human do Travellera i to działa
         */

        travellers.add((Traveller) human);
        /**
         * Tu też kompilator wierzy nam na słowo ale Eagle nie jest Travellerem, stąd przy próbie
         * podmiany kompilator wywala błąd że go oszukaliśmy
         */
        travellers.add((Traveller) eagle);
    }
}
