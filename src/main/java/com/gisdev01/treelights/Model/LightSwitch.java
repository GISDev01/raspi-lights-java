package com.gisdev01.treelights.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.annotation.sql.DataSourceDefinition;

@Data
@Entity
public class LightSwitch {
    private @Id
    @GeneratedValue Long id;
    private String name;
    private String state;

    private LightSwitch() {}

    public LightSwitch(String name, String state) {
        this.name = name;
        this.state = state;

    }

}
