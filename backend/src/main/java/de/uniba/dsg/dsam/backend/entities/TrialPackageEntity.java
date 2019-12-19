package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.Entity;

@Entity
public class TrialPackageEntity extends IncentiveEntity {

	private int id;
	private String name;
	private String type;
	
	public TrialPackageEntity(){ }

	public TrialPackageEntity(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}