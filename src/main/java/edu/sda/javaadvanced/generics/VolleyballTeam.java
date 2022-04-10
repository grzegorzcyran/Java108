package edu.sda.javaadvanced.generics;

public class VolleyballTeam extends Team {
    private TeamLevel teamLevel;

    public VolleyballTeam(String name, TeamLevel teamLevel) {
        super(name);
        this.teamLevel = teamLevel;
    }

    public TeamLevel getTeamLevel() {
        return teamLevel;
    }
}
