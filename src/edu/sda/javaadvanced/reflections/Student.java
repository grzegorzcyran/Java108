package edu.sda.javaadvanced.reflections;

public class Student extends Person{
    public String publicStudentField = "public student field";
    private String name;
    private String surname;
    String university;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        info("getSurname");
        return surname;
    }

    public void setSurname(String surname) {
        info("setSurname");
        this.surname = surname;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    private void info(String launcher) {
        System.out.println("Jestem w " + launcher);
    }
}
