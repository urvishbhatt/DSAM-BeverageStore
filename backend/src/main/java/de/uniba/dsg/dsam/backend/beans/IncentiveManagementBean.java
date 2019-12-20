package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.backend.entities.IncentiveEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Stateful
public class IncentiveManagementBean implements IncentiveManagement {

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	EntityManager entityManager;


	@Override
	public void create(Incentive incentive) {
		IncentiveEntity incentiveEntity = new IncentiveEntity(incentive.getName(),incentive.getType());
		entityManager.persist(incentiveEntity);
	}

	@Override
	public List<Incentive> getAllIncentive() {
		List<Incentive> listIncentive = entityManager.createNamedQuery("queryIncentive").getResultList();
		if(listIncentive == null) {
			ArrayList<Incentive> emptyList = new ArrayList<>();
			return emptyList;
		}
		else {
			return listIncentive;
		}
	}

	@Override
	public void delete(int id) {
		IncentiveEntity mybev = entityManager.find(IncentiveEntity.class, new Integer(id));
		entityManager.remove(mybev);
	}

	@Override
	public Incentive getIncentives(int incentiveID) {
		IncentiveEntity bev = entityManager.find(IncentiveEntity.class, new Integer(incentiveID));
		Incentive incentive = new Incentive(bev.getId(),bev.getName(), bev.getType());
		return incentive ;
	}

	@Override
	public void update(int incentiveID, String incentiveType) {
		IncentiveEntity bev = entityManager.find(IncentiveEntity.class, new Integer(incentiveID));
		bev.setName(incentiveType);
	}
}