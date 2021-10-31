package com.example.demo.tournament;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Tournament {
    private List<Team> teamsParticipating;
    private List<Match> matches;
    private Team tournamentWinner;

    @Autowired
    public Tournament() throws Exception{
        teamsParticipating = Data.readData();
        Collections.shuffle(teamsParticipating);
        matches = new ArrayList<>();
        Data.createFile();
    }

    public void generateMatches(String round) throws Exception{
        matches.clear();
        for(int i = 0; i < teamsParticipating.size(); i++){
            Match match = new Match(teamsParticipating.get(i), teamsParticipating.get(++i), round);
            matches.add(match);
        }
        printMatchesResults();
    }

    public void printMatchesResults() throws Exception{
        teamsParticipating.clear();
        for(int i = 0; i < matches.size(); i++){
            teamsParticipating.add(matches.get(i).getResult());
        }
        nextRound();
    }

    public void nextRound() throws Exception {
        String round = new String();
        if (teamsParticipating.size() >= 2){
            if (teamsParticipating.size() == 2) {
                round = "FINAL";
            } else {
                round = "1/" + teamsParticipating.size() / 2;
            }
            generateMatches(round);
        }
        else{
            tournamentWinner = teamsParticipating.get(0);
            ConsoleWriter.printWinner(tournamentWinner.getName());
            Data.closeFile();
        }
    }

}
