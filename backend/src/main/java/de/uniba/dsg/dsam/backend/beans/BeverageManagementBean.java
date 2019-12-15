package de.uniba.dsg.dsam.backend.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.persistence.BeverageManagement;

@Stateless
public class BeverageManagementBean implements BeverageManagement {

    @PersistenceContext(type= PersistenceContextType.TRANSACTION)
    EntityManager entityManager;

    @Override
    public void create(Beverage beverage) {
        BeverageEntity beverageEntity = new BeverageEntity(beverage.getManufacturer(), beverage.getName(), beverage.getQuantity(),beverage.getPrice());
        entityManager.persist(beverageEntity);
    }
}
