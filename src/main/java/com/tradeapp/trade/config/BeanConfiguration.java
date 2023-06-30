package com.tradeapp.trade.config;


import com.tradeapp.backend.Algo;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Configuration class used for creating beans required for the application
 */
@Configuration
public class BeanConfiguration {

    /**
     * Created an Algo instance, which is used to emulate the third party trading library provided by extenral team.
     *
     * @return The Algo instance
     */
    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    public Algo algo() {
        return new Algo();
    }

    /**
     * Creates an ExecutorService bean using a cached thread pool. This ExecutorService instance is used by SignalService
     *
     * @return The ExecutorService instance.
     */
    @Bean
    public ExecutorService executorService() {
        return Executors.newCachedThreadPool();
    }
}
