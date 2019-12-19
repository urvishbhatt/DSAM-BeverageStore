package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.backend.entities.CustomerOrderEntity;
import de.uniba.dsg.dsam.model.CustomerOrder;
import de.uniba.dsg.dsam.persistence.OrderMessage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.logging.Logger;

@Stateless
public class OrderMessageDrivenBean implements OrderMessage {
	private static final Logger logger = Logger.getLogger(OrderMessage.class.getName());
	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	
	EntityManager em;
	
	@Override
	public void create(CustomerOrder orderss) { }

	@Override
	public void create(String name, String manufacturer, int quantity) {
		CustomerOrderEntity b = new CustomerOrderEntity( name, manufacturer,   quantity);
		em.persist(b);
	}



   
}
