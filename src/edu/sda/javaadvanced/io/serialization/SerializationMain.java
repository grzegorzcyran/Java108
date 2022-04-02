package edu.sda.javaadvanced.io.serialization;

import java.io.*;

public class SerializationMain {

    public static void main(String[] args) {
        SerializedPerson person = new SerializedPerson(22, "Jan", "Kowalski", 33);

        try {
            FileOutputStream fout = new FileOutputStream("SerializedData.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(person);

            oos.close();
            fout.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
