package de.uniba.dsg.dsam.model;

import java.io.Serializable;

public class Incentive implements Serializable {
    private String name;
    private String description;
    private String incentive;

    public Incentive(String name, String description, String incentive) {
        this.name = name;
        this.description = description;
        this.incentive = incentive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIncentive() {
        return incentive;
    }

    public void setIncentive(String incentive) {
        this.incentive = incentive;
    }
}
