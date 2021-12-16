package model;

public class Team {

    private String name;

    private String coachName;

    private String captainName;

    public Team(String name, String coach, String captain){
        this.name = name;
        this.captainName = captain;
        this.coachName = coach;
    }

    public String getName() {
        return name;
    }

}
