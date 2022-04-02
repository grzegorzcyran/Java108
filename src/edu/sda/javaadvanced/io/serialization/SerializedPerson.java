package edu.sda.javaadvanced.io.serialization;

import java.io.Serializable;

/**
 * Serializable jest tzw. Flag Interface czyli interfejsem - znacznikiem
 * co oznacza że nie musimy implementować żadnej metody aby klasa spełniałą
 * ten interfejs, po prostu odblokowujemy dodatkowe możliwości dla klasy
 */

public class SerializedPerson implements Serializable {

    /**
     * transient będzie oznaczał że takie pole ma nie być pakowane do strumienia podczas serializacji obiektu
     * a podczas jego odczytywania (deserializacji) zakładamy że to pole nie będzie uzupełnione;
     * system wypełni je wartością domyślną (String - null, int - 0, boolean - false, itp)
     */
    private transient int id;
    private String name;
    private String surName;
    private int age;

    public SerializedPerson(int id, String name, String surName, int age) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SerializedPerson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                '}';
    }
}
