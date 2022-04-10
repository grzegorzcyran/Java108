package edu.sda.javaadvanced.generics;

public enum TeamLevel {

    AMATEUR("stadion", "A"),
    PROFESSIONAL("arena", "P");

    private String place;
    private String abbreviation;

    TeamLevel(String place, String abbreviation) {
        this.place = place;
        this.abbreviation = abbreviation;
    }

    public String getPlace() {
        return place;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static TeamLevel getByAbbreviation(String abbreviation) {
        for (TeamLevel level : TeamLevel.values()) {
            if (abbreviation.equalsIgnoreCase(level.getAbbreviation())) {
                return level;
            }
        }
        return null;
    }
}
