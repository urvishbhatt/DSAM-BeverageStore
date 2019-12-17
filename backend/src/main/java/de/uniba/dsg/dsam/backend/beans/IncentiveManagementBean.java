package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.backend.entities.IncentiveEntity;
import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

@Stateless
public class IncentiveManagementBean implements IncentiveManagement {
    @PersistenceContext(type= PersistenceContextType.TRANSACTION)
    EntityManager entityManager;

    @Override
    public void create(Incentive incentive) {
        IncentiveEntity incentiveEntity = new IncentiveEntity(incentive.getName(),incentive.getDescription(),incentive.getIncentive());

        entityManager.persist(incentiveEntity);
    }
}
