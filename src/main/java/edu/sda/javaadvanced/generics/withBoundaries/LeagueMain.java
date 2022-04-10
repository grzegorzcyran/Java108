package edu.sda.javaadvanced.generics.withBoundaries;

import edu.sda.javaadvanced.generics.FootballTeam;
import edu.sda.javaadvanced.generics.Team;
import edu.sda.javaadvanced.generics.TeamLevel;
import edu.sda.javaadvanced.generics.VolleyballTeam;

public class LeagueMain {
    public static void main(String[] args) {
        League<FootballTeam> footballLeague = new League<>("Primiera Division");
        League<VolleyballTeam> volleyballLeague = new League<>("Plus Liga");

        FootballTeam team1 = new FootballTeam("FC Barcelona", TeamLevel.PROFESSIONAL);
        FootballTeam team2 = new FootballTeam("Atletico de Madrid", TeamLevel.PROFESSIONAL);
        Team team3 = new FootballTeam("Real Madrid CF", TeamLevel.PROFESSIONAL);
        Team team4 = new FootballTeam("Valencia CF", TeamLevel.PROFESSIONAL);
        team1.setPoins(30);
        team2.setPoins(40);
        team3.setPoins(10);
        team4.setPoins(20);
        footballLeague.addTeam(team1);
        footballLeague.addTeam(team2);
        footballLeague.addTeam((FootballTeam) team3); //footballLeague jest określona jako League<FootballTeam>
        //więc trzeba jawnie powiedzieć kompilatorowi że team3 ma traktować jak FootballTeam
        footballLeague.addTeam((FootballTeam) team4);
        footballLeague.addTeam(team1);
        System.out.println("==================");
        footballLeague.printTable();
        System.out.println("==================");

    }
}
