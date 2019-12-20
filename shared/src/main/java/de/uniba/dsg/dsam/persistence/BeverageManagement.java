package de.uniba.dsg.dsam.persistence;

import de.uniba.dsg.dsam.model.Beverage;

import java.util.List;

public interface BeverageManagement {
   	public void create(String manufacturer, String name, String promotion, int quantity, double price);
   	public List<Beverage> getBeverages();
	public Beverage getBeverages(int bevID);
	public void update(int id, String manufacturer, String name, String promotion, int quantity, double price);
   	public void update(int id, String promotion);
    public void delete(int bevID) ;
}