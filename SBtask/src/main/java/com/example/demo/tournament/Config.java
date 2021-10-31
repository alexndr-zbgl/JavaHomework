package com.example.demo.tournament;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Tournament tournamentBean() throws Exception{
        return new Tournament();
    }

}
