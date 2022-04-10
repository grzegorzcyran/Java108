package edu.sda.javaadvanced.collections.stack;

import edu.sda.javaadvanced.collections.Car;

import java.util.Deque;
import java.util.LinkedList;

public class StackDemo {

    public static void main(String[] args) {
        Car car1 = new Car("Volvo", "2.0", 190);
        Car car2 = new Car("Ford", "1.6", 220);
        Car car3 = new Car("BMW", "3.2", 260);
        Car car4 = new Car("Fiat", "1.1", 160);

        /**
         * Stack czyli stos
         * Realizuje mechanizm LIFO
         * czyli Last In First Out
         * Pierwszy element który trafi na stos jest z niego wyjmowany jako ostatni

            Realizowany za pomocą Deque
         */

        //wstawianie elementów konsekwentnie jedną metodą (zawsze offerFirst albo zawsze offerLast)
        Deque<Car> stack = new LinkedList<>();
        System.out.println("Wstawiamy " + car1);
        stack.offerLast(car1);
        System.out.println("Wstawiamy " + car2);
        stack.offerLast(car2);
        System.out.println("Wstawiamy " + car3);
        stack.offerLast(car3);
        System.out.println("Wstawiamy " + car4);
        stack.offerLast(car4);

        //zdejmowanie elementów ze stosu zawsze jedną metodą
        //jeśli wstawianie było First to zdejmowanie First
        System.out.println("Zdejmowanie ze stosu:");
        while (stack.size() > 0) {
            System.out.println("Zdejmujemy " + stack.peekLast().getCarInfo());
            System.out.println(stack.pollLast());
        }

        System.out.println("=======================");
        System.out.println("=======================");
        System.out.println("=======================");

        Stack<Car> carStack= new Stack<>();
        carStack.put(car1);
        carStack.put(car2);
        carStack.put(car3);
        carStack.put(car4);

        carStack.take();
        carStack.take();
        carStack.take();
        carStack.take();
    }
}
