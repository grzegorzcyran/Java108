package edu.sda.javaadvanced.generics.nonGeneric;

import edu.sda.javaadvanced.generics.FootballTeam;
import edu.sda.javaadvanced.generics.Team;
import edu.sda.javaadvanced.generics.TeamLevel;
import edu.sda.javaadvanced.generics.VolleyballTeam;

public class LeagueMain {
    public static void main(String[] args) {
        League league = new League("Primiera Division");

        Team team1 = new FootballTeam("FC Barcelona", TeamLevel.PROFESSIONAL);
        Team team2 = new FootballTeam("Real Madrid CF", TeamLevel.PROFESSIONAL);
        Team team3 = new FootballTeam("Atletico de Madrid", TeamLevel.PROFESSIONAL);
        Team team4 = new FootballTeam("Valencia CF", TeamLevel.PROFESSIONAL);
        team1.setPoins(30);
        team2.setPoins(25);
        team3.setPoins(33);
        team4.setPoins(28);

        league.addTeam(team1);
        league.addTeam(team2);
        league.addTeam(team3);
        league.addTeam(team4);
        System.out.println("===========");
        league.printTable();
        System.out.println("===========");
        Team team5 = new VolleyballTeam("Asseco Resovia", TeamLevel.PROFESSIONAL);
        league.addTeam(team5);
        team5.setPoins(27);
        league.printTable();
    }
}
