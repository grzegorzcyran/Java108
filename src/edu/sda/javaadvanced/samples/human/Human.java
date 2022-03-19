package edu.sda.javaadvanced.samples.human;

public abstract class Human implements Sailor {
    private String name;
    private String surname;

    private Gender gender; //enum prosty
    private Location location;

    public Human(String name, String surname, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public Location getLocation() {
        return location;
    }

    public Location adjustLocation(String newLocationShortname) {
        //TODO add setting new location
        Location foundLocation = Location.findByShortname(newLocationShortname);
        if(foundLocation != null) {
            System.out.println("Lokacja znaleziona, ustawiam na " + foundLocation.getPlName());
            location = foundLocation;
        }
        return location;
    }

    @Override
    public String sail() {
        //Enum można sprawdzać przez ==
        if(location == Location.LAND) {
            throw new LackOfWaterException(location.getPlName());
        }
        return "Sailing over " + location.getEngName();
    }
}
