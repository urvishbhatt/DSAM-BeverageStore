package de.uniba.dsg.dsam.model;

import java.io.Serializable;

<<<<<<< HEAD
public class Beverage  implements Serializable {
=======
public class Beverage implements Serializable {
>>>>>>> 2a32726f083ccdb65e2ed1aa2b81309abcb5cd2f
    private String manufacturer;
    private String name;
    private int quantity;
    private double price;
<<<<<<< HEAD

    private Incentive incentive;

=======
    private Incentive incentive;

    public Beverage(String manufacturer, String name, int quantity, double price, Incentive incentive) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.incentive = incentive;
    }

>>>>>>> 2a32726f083ccdb65e2ed1aa2b81309abcb5cd2f
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

    public Incentive getIncentive() {
        return incentive;
    }

    public void setIncentive(Incentive incentive) {
        this.incentive = incentive;
    }
<<<<<<< HEAD

    public Beverage(String manufacturer, String name, int quantity, double price, Incentive incentive) {
        this.manufacturer = manufacturer;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.incentive = incentive;
    }
=======
>>>>>>> 2a32726f083ccdb65e2ed1aa2b81309abcb5cd2f
}
