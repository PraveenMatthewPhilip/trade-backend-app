package com.tradeapp.trade.config;


import com.tradeapp.backend.Algo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AlgoConfiguration {

    @Bean
    public Algo algo() {
        return new Algo();
    }
}
