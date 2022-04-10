package edu.sda.javaadvanced.generics.withBoundaries;

import edu.sda.javaadvanced.generics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T extends Team> {
    private String leagueName;
    private List<T> teams;

    public League(String leagueName) {
        this.leagueName = leagueName;
        teams = new ArrayList<>();
    }

    public boolean addTeam(T team) {
        if(!teams.contains(team)) {
            System.out.println("Adding " + team.getName() + " to " + leagueName);
            return teams.add(team);
        }
        System.out.println(team.getName() + " already in " + leagueName);
        return false;
    }

    public void printTable() {
        Collections.sort(teams);
        System.out.println(leagueName + " table: ");
        for (T team : teams) {
            System.out.println(team.getName() + "  " + team.getPoins());
        }
    }

    //random
}
