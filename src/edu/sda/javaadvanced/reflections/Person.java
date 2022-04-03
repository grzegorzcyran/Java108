package edu.sda.javaadvanced.reflections;

public class Person {

    public String publicPersonField = "public person field";
    private int age;
    private int gender;

    public int getAge() {
        info("getAge");
        return age;
    }

    public void setAge(int age) {
        info("setAge");
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    private void info(String launcher) {
        System.out.println("Jestem w " + launcher);
    }
}
