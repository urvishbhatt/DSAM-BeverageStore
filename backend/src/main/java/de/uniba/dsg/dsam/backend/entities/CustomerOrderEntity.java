package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.*;
import java.util.Date;


@Entity
public class CustomerOrderEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;

	private String manufacturer;
    private String name;
    private int quantity;
	private Date issueDate;
            	
	public CustomerOrderEntity(){ }

	public CustomerOrderEntity(String name , String manufacturer, int quantity ) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
	}

	public CustomerOrderEntity(String name, String manufacturer, int quantity, Date issueDate) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.quantity = quantity;
		this.issueDate = issueDate;
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

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
}