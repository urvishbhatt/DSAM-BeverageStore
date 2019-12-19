package de.uniba.dsg.dsam.persistence;

import de.uniba.dsg.dsam.model.CustomerOrder;

import java.util.List;

public interface OrderMessage {
	public void create(CustomerOrder orderss);
	public void create(String name, String manufacturer, int quantity);
	public List<CustomerOrder> getOrderList();
}