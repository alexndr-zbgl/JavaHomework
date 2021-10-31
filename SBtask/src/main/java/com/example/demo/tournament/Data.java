package com.example.demo.tournament;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.PrintWriter;

public class Data {

    private static String filePath = "data.csv";
    private static String writePath = "write_file.csv";
    private static PrintWriter writer;

    public static void createFile() throws Exception{
        writer = new PrintWriter(writePath);
    }

    public static List<Team> readData() throws IOException {
        return parseTeamsData();
    }

    public static void closeFile(){
        writer.close();
    }

    private static List<Team> parseTeamsData() throws IOException {
        List<Team> teams = new ArrayList<>();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }
        for(List<String> e: records){
            Team team = new Team(e);
            teams.add(team);
        }

        return teams;
    }

    public static void writeDataToFile(String matchInfo) {
        StringBuilder info = new StringBuilder();
        info.append(matchInfo);

        writer.write(info.toString());
        writer.write("\n");

    }

}
