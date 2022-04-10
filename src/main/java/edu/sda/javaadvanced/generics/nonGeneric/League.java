package edu.sda.javaadvanced.generics.nonGeneric;

import edu.sda.javaadvanced.generics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League {
    private String leagueName;
    private List<Team> teams;

    public League(String leagueName) {
        this.leagueName = leagueName;
        this.teams = new ArrayList<>();
    }

    public boolean addTeam(Team team) {
        if(!teams.contains(team)) {
            System.out.println("Adding " + team.getName() + " to " + leagueName);
            return teams.add(team);
        }
        System.out.println("Team " + team + " already in " + leagueName);
        return false;
    }

    public void printTable() {
        Collections.sort(teams);
        System.out.println(leagueName + " table:");
        for (Team team : teams) {
            System.out.println(team.getName() + ", points:  " + team.getPoins());
        }
    }
}
