package edu.sda.javaadvanced.generics;

public abstract class Team implements Comparable<Team> {

    private String name;
    private int poins;

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPoins() {
        return poins;
    }

    public void setPoins(int poins) {
        this.poins = poins;
    }

    @Override
    public int compareTo(Team team) {
        return team.getPoins() - this.poins;
    }
}
