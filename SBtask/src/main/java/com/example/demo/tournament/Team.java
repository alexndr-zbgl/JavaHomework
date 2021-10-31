package com.example.demo.tournament;

import com.opencsv.bean.CsvBindByPosition;

import java.util.List;

public class Team {

    @CsvBindByPosition(position = 0)
    private String name;

    @CsvBindByPosition(position = 1)
    private String captain;

    @CsvBindByPosition(position = 3)
    private String coach;

    public Team(){}

    public Team(String name, String captain, String coach) {
        this.name = name;
        this.captain = captain;
        this.coach = coach;
    }

    public Team(List<String> teamData){
        this.name = teamData.get(0);
        this.captain = teamData.get(1);
        this.coach = teamData.get(2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", captain='" + captain + '\'' +
                ", coach='" + coach + '\'' +
                '}';
    }
}
