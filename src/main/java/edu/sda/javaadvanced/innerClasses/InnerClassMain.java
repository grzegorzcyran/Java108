package edu.sda.javaadvanced.innerClasses;

public class InnerClassMain {

    public static void main(String[] args) {
        //najpierw tworzymy obiekt zewnętrzny
        CommonCar commonCar = new CommonCar("Porche Panamera");

        //Obiekt wewnętrzny
        CommonCar.Engine engine = commonCar.new Engine("PB", 350);

        System.out.println(engine.getEngineInfo());
        System.out.println("=====================");
        System.out.println(engine.getAllCarInfo());
        System.out.println("=====================");
        System.out.println(commonCar.getName());
    }
}
