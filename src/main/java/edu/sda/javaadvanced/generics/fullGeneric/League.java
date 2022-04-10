package edu.sda.javaadvanced.generics.fullGeneric;

import edu.sda.javaadvanced.generics.Team;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class League<T> {
    private String leagueName;
    private List<T> teams;

    public League(String leagueName) {
        this.leagueName = leagueName;
        teams = new ArrayList<>();
    }

    //dobry kandydat na metodę generyczną
    public boolean addTeam(T team) {
        if(!teams.contains(team)) {
            System.out.println("Adding " + team.toString() + " to league " + leagueName);
            return teams.add(team);
        }
        System.out.println(team.toString() + " already in " + leagueName);
        return false;
    }

    //Ta metoda nie jest dobrym kandydatem do klasy generycznej,
    //bo wymusza rzutowanie - wyjaśnienie poniżej przy sortowaniu
    public void printTable() {
        //Collections.sort(teams); // nie da się zrobić tak po prostu .sort bo java nie wie czy klasa
        //którą przekażemy jako "T" będzie rozszerzała Comparable
        //więc tutaj MUSIMY powiedzieć jawnie co za klasa przychodzi

        Collections.sort((List<Team>) teams);
        System.out.println(leagueName + " table:");
        for (T team : teams) {
            //wypisywanie też nie jest dowolne bo bazujemy na założeniu że w klasie będzie metoda
            //getName() i metoda getPoints()
            System.out.println(((Team) team).getName() + ", points: " + ((Team) team).getPoins());
        }

    }

}
