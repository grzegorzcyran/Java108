package edu.sda.javaadvanced.generics;

public class FootballTeam extends Team {
    private TeamLevel teamLevel;

    public FootballTeam(String name, TeamLevel teamLevel) {
        super(name);
        this.teamLevel = teamLevel;
    }

    public TeamLevel getTeamLevel() {
        return teamLevel;
    }
}
