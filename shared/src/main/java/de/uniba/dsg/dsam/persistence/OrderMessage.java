package de.uniba.dsg.dsam.persistence;

import de.uniba.dsg.dsam.model.CustomerOrder;

public interface OrderMessage {
	public void create(CustomerOrder orderss);
	public void create(String name, String manufacturer, int quantity);
}