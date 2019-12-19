package de.uniba.dsg.dsam.model;

import java.io.Serializable;

public class Incentive implements Serializable {

	public int id;
	public String type;
	public String name;

	public Incentive(){ }

	public Incentive(String name, String type) {
		this.name = name;
		this.type = type;
	}

	public Incentive(int id,String name, String type) {
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public String getType() { return type; }

	public void setType(String type) { this.type = type; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public int getId() { return id; }

	public void setId(int id) { this.id = id; }
}
