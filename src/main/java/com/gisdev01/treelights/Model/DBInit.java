package com.gisdev01.treelights.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInit implements CommandLineRunner {

    private final LightSwitchRepository repository;

    @Autowired
    public DBInit(LightSwitchRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... strings) throws Exception {
        this.repository.save(new LightSwitch("Christmas Tree DB data", "Off"));
        this.repository.save(new LightSwitch("Front Lawn", "Off"));
        this.repository.save(new LightSwitch("Rooftop", "Off"));
    }
}
