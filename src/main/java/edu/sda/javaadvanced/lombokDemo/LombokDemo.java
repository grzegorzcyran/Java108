package edu.sda.javaadvanced.lombokDemo;

import lombok.extern.slf4j.Slf4j;

//@Slf4j
public class LombokDemo {

    public static void main(String[] args) {

        //log.info("aaa");
        LombokPerson person1 = new LombokPerson();

        LombokPerson person2 = new LombokPerson("Jaś", "Kowalski");

        person1.setName("Mariola");
        person1.setSurname("Chodzińska");

        System.out.println(person2.toString());
        System.out.println("Getter test: " +person1.getName() + " " + person1.getSurname());

    }
}
