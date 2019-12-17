package de.uniba.dsg.dsam.persistence;

import de.uniba.dsg.dsam.model.Beverage;

import java.util.List;

public interface BeverageManagement {

    public void create(Beverage beverage);

    public List<Beverage> getBeverages();

}
