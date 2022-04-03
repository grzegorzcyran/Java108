package edu.sda.javaadvanced.innerClasses;

public class CommonCar {

    private String name;

    public String getName() {
        return name;
    }

    public CommonCar(String name) {
        this.name = name;
    }

    /**
     * Wewnętrzna klasa Engine
     *
     * Klasa wewnętrzna ma dostęp do wszystkich pól i metod klasy zewnętrznej
     */
    class Engine {
        private String engineType;
        private int enginePower;

        public Engine(String engineType, int enginePower) {
            this.engineType = engineType;
            this.enginePower = enginePower;
        }

        public String getEngineInfo() {
            return new StringBuilder("Silnik ").append(engineType)
                    .append(" o mocy ").append(enginePower)
                    .toString();
        }

        public String getAllCarInfo() {
            return new StringBuilder("Samochód ").append(name)
                    .append(" z silnikiem ").append(engineType)
                    .append(" o mocy ").append(enginePower)
                    .toString();
        }
    }
}
