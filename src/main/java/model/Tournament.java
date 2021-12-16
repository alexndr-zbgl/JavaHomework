package model;

import additional.ConsoleWriter;
import additional.DataOperations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tournament {

    private List<Match> matches;
    private Team winner;
    private List<Team> teamsParticipating;

    public Tournament() throws Exception{
        teamsParticipating = DataOperations.getTeams();
        Collections.shuffle(teamsParticipating);
        matches = new ArrayList<>();
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
        String round;
        if (teamsParticipating.size() >= 2){
            if (teamsParticipating.size() == 2) {
                round = "FINAL";
            } else {
                round = "1/" + teamsParticipating.size() / 2;
            }
            generateMatches(round);
        }
        else{
            winner = teamsParticipating.get(0);
            ConsoleWriter.printWinner(winner.getName());
            DataOperations.writeWinner(winner.getName());
        }
    }


}
