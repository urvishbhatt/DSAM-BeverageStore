package de.uniba.dsg.dsam.persistence;

import de.uniba.dsg.dsam.model.CustomerOrder;

import java.util.List;

public interface OrderManagement {
	public void create(CustomerOrder orders);
	public void create(String name, String manufacturer, int quantity);
	public List<CustomerOrder> getOrderList();
}