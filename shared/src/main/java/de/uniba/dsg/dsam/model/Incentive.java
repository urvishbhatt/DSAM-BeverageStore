package de.uniba.dsg.dsam.model;

import java.io.Serializable;

public class Incentive implements Serializable {
    private String name;


    public Incentive(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
