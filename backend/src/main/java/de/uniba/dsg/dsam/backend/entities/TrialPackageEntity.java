package de.uniba.dsg.dsam.backend.entities;

import javax.persistence.Entity;

@Entity
public class TrialPackageEntity extends IncentiveEntity {
	
	private String Name;
	
	public TrialPackageEntity(){
		
	}

	public TrialPackageEntity(String incentiveType, String name) {
		this();
		//this.setId(id);
		this.setIncentive("Trial");
		this.Name = name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
}