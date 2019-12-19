package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.Entity;

@Entity
public class PromotionalGiftEntity extends IncentiveEntity {

	private int id;
	private String name;
	private String type;
	
	public PromotionalGiftEntity(){ }

	public PromotionalGiftEntity(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
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