package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BeverageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)

    private int id;

    public String manufacturer;
    public String name;
    public int quantity;
    public double price;
    public String incentive;

    public BeverageEntity() { }

    public BeverageEntity(String manufacturer, String name, int quantity, double price, String incentive) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.incentive = incentive;
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
