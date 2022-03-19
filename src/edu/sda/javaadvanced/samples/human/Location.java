package edu.sda.javaadvanced.samples.human;

public enum Location {

    SEA("m", "morze", "sea"),
    LAKE("j", "jezioro", "lake"),
    LAND("l", "ląd", "land");

    private String shortname;
    private String plName;
    private String engName;

    Location(String shortname, String plName, String engName) {
        this.shortname = shortname;
        this.plName = plName;
        this.engName = engName;
    }

    public String getShortname() {
        return shortname;
    }

    public String getPlName() {
        return plName;
    }

    public String getEngName() {
        return engName;
    }

    public static Location findByShortname(String shortname) {
        for (Location location : Location.values()) {
            if(shortname.equalsIgnoreCase(location.shortname)) {
                return location;
            }
        }
        return null;
    }
}
