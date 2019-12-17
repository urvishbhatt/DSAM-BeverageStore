package de.uniba.dsg.dsam.backend.beans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.persistence.BeverageManagement;

import java.util.ArrayList;
import java.util.List;

@Stateless
public class BeverageManagementBean implements BeverageManagement {

    @PersistenceContext(type= PersistenceContextType.TRANSACTION)
    EntityManager entityManager;

    @Override
    public void create(Beverage beverage) {
        BeverageEntity beverageEntity = new BeverageEntity(beverage.getManufacturer(), beverage.getName(), beverage.getQuantity(),beverage.getPrice(),beverage.getIncentive());
        entityManager.persist(beverageEntity);
    }

    @Override
    public List<Beverage> getBeverages() {
        List<Beverage> listBeverage = entityManager.createNamedQuery("queryBeverages").getResultList();


        if(listBeverage == null) {
            return new ArrayList<Beverage>();
        }
        else {
            return listBeverage;
        }
    }
}
