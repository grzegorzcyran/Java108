package edu.sda.javaadvanced.samples.human;

public class Demo {

    public static void main(String[] args) {
        Seller seller1 = new Seller("Jan", "Kowalski", Gender.MALE);
        Student student1 = new Student("Apolinary", "Nowak", Gender.MALE);
        Seller seller2 = new Seller("Martuna", "Wojciechowicz", Gender.FEMALE);
        Student student3 = new Student("Robert", "Walczak", Gender.MALE);

        seller1.changeBranch("AGD");
        seller2.changeBranch("Budowlanka");
        student1.chooseFaculty("Elektronika");
        student3.chooseFaculty("Marketing");

        seller1.setFamilyDestination("Kielce");
        seller1.setWorkDestination("Chorzów");
        seller1.setWorking(true);
        seller2.setFamilyDestination("Warszawa");
        seller2.setWorkDestination("Poznań");
        seller2.setWorking(false);

        student1.adjustLocation("m");
        student3.adjustLocation("l");
        seller1.adjustLocation("a");
        seller2.adjustLocation("j");

        System.out.println("Student 1 pływa?: " + student1.sail());
        try {
            System.out.println("Student 3 pływa?: " + student3.sail());
        } catch (Exception e) {
            System.out.println("Olać wyjątki, jedziemy dalej, YOLO!");
        }

        System.out.println(seller1.getSurname() + " jedzie do  " + seller1.driveTo() + " bo kierunek " + (seller1.isWorking() ? " praca" : " dom"));;
        System.out.println(seller2.getSurname() + " jedzie do  " + seller2.driveTo() + " bo kierunek " + (seller2.isWorking() ? " praca" : " dom"));;


    }
}
