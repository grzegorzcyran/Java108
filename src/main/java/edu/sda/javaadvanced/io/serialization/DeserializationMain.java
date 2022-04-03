package edu.sda.javaadvanced.io.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationMain {

    public static void main(String[] args) {
        SerializedPerson person = null;

        try {
            FileInputStream fis = new FileInputStream("SerializedData.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);

            person = (SerializedPerson) ois.readObject();

            System.out.println("Odczytujemy zserializowane dane\n");
            System.out.println(person.getName() + " " + person.getSurName());
            System.out.println(person);
            System.out.println(person.getId());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
