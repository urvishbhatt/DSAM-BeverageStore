package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.backend.entities.IncentiveEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Stateless
public class IncentiveManagementBean implements IncentiveManagement {
	
	private static final Logger logger = Logger.getLogger(IncentiveManagementBean.class.getName());

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	EntityManager em;

	@Override
	public void create(Incentive incentive, Boolean isTrial) {
		IncentiveEntity incentiveEntity = new IncentiveEntity(incentive.getName(),incentive.getType());
		em.persist(incentiveEntity);
	}

	@Override
	public List<Incentive> getAllIncentive() {
		List<Incentive> listIncentive = em.createNamedQuery("queryIncentive").getResultList();
		if(listIncentive == null) {
			ArrayList<Incentive> emptyList = new ArrayList<>();
			return emptyList;
		}
		else {
			return listIncentive;
		}
	}

	//Unused
	@Override
	public void create(Incentive incentive) { }

	@Override
	public void create(String incentiveType, String name) { }

	@Override
	public Incentive getIncentives(int incentiveID) {
		return null;
	}

	@Override
	public void update(int incentiveID, String incentiveType) { }

	@Override
	public void delete(int incentiveID) { }
	//
}