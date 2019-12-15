package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BeverageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE)

    private int id;

    public BeverageEntity() { }

    public String manufacturer;
    public String name;
    public int quantity;
    public double price;

    public BeverageEntity(String manufacturer, String name, int quantity, double price) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
