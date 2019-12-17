package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class IncentiveEntity implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)
    private int id;

    private String name;
    private String description;
    private String incentive;

    public IncentiveEntity() { }

    public IncentiveEntity(String name, String description, String incentive) {
        this.name = name;
        this.description = description;
        this.incentive = incentive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
