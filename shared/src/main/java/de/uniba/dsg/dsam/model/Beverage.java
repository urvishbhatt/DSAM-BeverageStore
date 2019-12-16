package de.uniba.dsg.dsam.model;

import java.io.Serializable;

public class Beverage implements Serializable {
    private String manufacturer;
    private String name;
    private int quantity;
    private double price;
    private String incentive;

    public Beverage(String manufacturer, String name, int quantity, double price, String incentive) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.quantity =  quantity;
        this.price = price;
        this. incentive = incentive;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIncentive() {
        return incentive;
    }

    public void setIncentive(String incentive) {
        this.incentive = incentive;
    }
}