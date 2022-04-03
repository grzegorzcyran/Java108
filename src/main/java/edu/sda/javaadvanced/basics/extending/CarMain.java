package edu.sda.javaadvanced.basics.extending;

public class CarMain {

    public static void main(String[] args) {
        TruckCar truckCar = new TruckCar(300);
        truckCar.setColor("Niebieski");
        truckCar.setName("MAN");

        System.out.println(truckCar.getName() + " " + truckCar.getColor());

        System.out.println("===================");
        System.out.println("===================");
        //Ponoższe dwa wywołania są sobie równe ponieważ przekazanie obiektu
        //do metody println powoduje wywołanie toString() na tym obiekcie
        System.out.println(truckCar.toString());
        System.out.println("===================");
        System.out.println(truckCar);
        System.out.println("===================");

        FerrariCar ferrariCar = new FerrariCar("VX", "niebieski", 4, "Turbo");
        System.out.println("Ferrari: " + ferrariCar.getName());
        System.out.println("Kolor: " + ferrariCar.getColor());
        System.out.println("Kolor oryginalny:" + ferrariCar.getOriginalColor());
        System.out.println("Kolor z dodatkami:" + ferrariCar.getColor(" w paski"));

        System.out.println("Truck: " + truckCar.getColor());


    }
}
