package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.*;


@Entity
public class CustomerOrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;

	private String manufacturer;
    private String name;
    private int quantity;
            	
	public CustomerOrderEntity(){ }

	public CustomerOrderEntity(String name , String manufacturer, int quantity ) {
		this.manufacturer = manufacturer;
		this.name = name;
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}