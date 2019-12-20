package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.backend.entities.BeverageEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.persistence.BeverageManagement;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Stateful
public class BeverageManagementBean implements BeverageManagement {

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	EntityManager entityManager;
    
    @Override
	public void create(String manufacturer, String name, String promotion, int quantity, double price) {
    	BeverageEntity b = new BeverageEntity( manufacturer,  name,  promotion, quantity, price);
		entityManager.persist(b);
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
	
	@Override
	public Beverage getBeverages(int bevID) {
		BeverageEntity bv = entityManager.find(BeverageEntity.class, new Integer(bevID));
		return convert(bv);
	}

	private Beverage convert(BeverageEntity bev) {
		Beverage ret = new Beverage(bev.getId(), bev.getManufacturer(), bev.getName(), bev.getpromotion(),bev.getQuantity(), bev.getPrice() );
		return ret;
	}

	@Override
	public void update(int id, String manufacturer, String name, String promotion, int quantity, double price) {
		BeverageEntity bev = entityManager.find(BeverageEntity.class, new Integer(id));
		bev.setManufacturer(manufacturer);
		bev.setName(name);
		bev.setpromotion(promotion);
		bev.setQuantity(quantity);
		bev.setPrice(price);
	}

	@Override
	public void update(int id, String promotion) {
		BeverageEntity bev = entityManager.find(BeverageEntity.class, new Integer(id));
		bev.setpromotion(promotion);
	}
	
	@Override
	public void delete(int bevID) {
		BeverageEntity mybev = entityManager.find(BeverageEntity.class, new Integer(bevID));
		entityManager.remove(mybev);
	}
}