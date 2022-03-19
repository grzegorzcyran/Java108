package edu.sda.javaadvanced.samples.human;

public class Student extends Human implements Driver {
    private String faculty;

    public Student(String name, String surname, Gender gender) {
        super(name, surname, gender);
    }

    public String getFaculty() {
        return faculty;
    }

    public void chooseFaculty(String faculty) {
        this.faculty = faculty;
    }

    @Override
    public String driveTo() {
        return "Do domu po słoiki i piniondz";
    }
}
