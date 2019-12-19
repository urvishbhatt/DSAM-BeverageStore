package de.uniba.dsg.dsam.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CustomerOrder implements Serializable {

    private int id;
    private String name;
    private String manufacturer;
    private int quantity;
    private Date issueDate;

    public CustomerOrder(int id, String name, String manufacturer, int quantity, Date issueDate) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.issueDate = issueDate;
    }

    public CustomerOrder(String name, String manufacturer, int quantity, Date issueDate) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() { return manufacturer; }

    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getQuantity() { return quantity; }

    public void setQuantity(int quantity) { this.quantity = quantity; }

    public Date getIssueDate() { return issueDate; }

    public void setIssueDate(Date issueDate) { this.issueDate = issueDate; }
}