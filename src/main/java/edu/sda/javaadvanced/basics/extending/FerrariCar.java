package edu.sda.javaadvanced.basics.extending;

public class FerrariCar extends SportCar {
    private String modelName;

    public FerrariCar(String name, String color, int accelerationTo100, String modelName) {
        super(name, color, accelerationTo100);
        System.out.println("Konstruktor klasy FerrariCar");
        this.modelName = modelName;
    }

    public String getModelName() {
        return modelName;
    }

    //możemy nadpisać definicję metody odziedziczonej tak, aby dla jednej z podklas zachowywała się
    //ona inaczej

    @Override
    public String getColor() {
        return "Ferrari jest zawsze czerwone";
    }

    /**
     * Metoda z innym zestawem parametrów (w tym przypadku "String addon")
     * jest niezależna od metody getColor() i nie powoduje "przykrycia" metody z nadklasy
     */
    public String getColor(String addon) {
        return "Ferrari jest czerwone i " + addon;
    }

    //jeśli jednak chcemy dobrać się do tego ustawionego koloru
    //to musimy to zrobić za pomocą słowa kluczowego super
    public String getOriginalColor() {
        //super oznacza tu "sięgnij do obiektu bazowego i z niego wywołaj metodę getColor()"
        //czyli pomijamy FerrariCar, idziemy do SportCar, jeśli tam nie ma metody getColor()
        //to w górę drzewa dziedziczenia do Car i wywołujemy tamtą metodę getColor()

        //!!!Wybierana jest najbliższa napotkana metoda getColor()
        return super.getColor();
    }
}
