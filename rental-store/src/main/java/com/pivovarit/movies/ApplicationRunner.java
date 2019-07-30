package com.pivovarit.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
class ApplicationRunner implements CommandLineRunner {

    @Value("${bbh.message}")
    private String message;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(message);
    }
}
