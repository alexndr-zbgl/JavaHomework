package com.example.demo.tournament;

import java.util.HashMap;
import java.util.Map;

public class Match {
    private String round;
    private Team teamOne;
    private Team teamTwo;
    private String score;

    public String getRound() {
        return round;
    }

    public Team getTeamOne() {
        return teamOne;
    }

    public Team getTeamTwo() {
        return teamTwo;
    }

    public String getScore() {
        return score;
    }

    public Match(Team teamOne, Team teamTwo,  String round){
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.round = round;
    }

    public Team getResult() throws Exception{
        Map<Team, Integer> result = new HashMap<>();

        int teamOneScore = (int) (Math.random() * 5);
        int teamTwoScore = (int) (Math.random() * 5);

        if(teamOneScore == teamTwoScore){
            teamOneScore++;
        }

        result.put(teamOne, teamOneScore);
        result.put(teamTwo, teamTwoScore);

        setScore(result.get(teamOne), result.get(teamTwo));

        ConsoleWriter.printMatch(result, this);

        Data.writeDataToFile(this.toString());

        if(result.get(teamOne) > result.get(teamTwo)){
            return teamOne;
        }
        else{
            return teamTwo;
        }
    }

    public void setScore(int teamOneResult, int teamTwoResult){
        this.score = teamOneResult + ":" + teamTwoResult;
    }

    public void printResult(){
        System.out.println("Round, Team 1, Team 2, Score");
        System.out.println(round + " " + teamOne + " " + teamTwo + " " + score);
    }

    @Override
    public String toString() {
        return "Round, Team1, Team2, Score\n"
                + round + ", " + teamOne.getName() + ", " + teamTwo.getName() + ", " + score;
    }
}
