package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.backend.entities.CustomerOrderEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.CustomerOrder;
import de.uniba.dsg.dsam.persistence.OrderMessage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
import java.util.logging.Logger;

@Stateless
public class OrderMessageDrivenBean implements OrderMessage {
	private static final Logger logger = Logger.getLogger(OrderMessage.class.getName());
	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	EntityManager em;
	
	@Override
	public void create(CustomerOrder orderss) {
		CustomerOrderEntity customerOrderEntity = new CustomerOrderEntity(orderss.getName(),orderss.getManufacturer(),orderss.getQuantity(),orderss.getIssueDate());
		logger.severe("My Test create method");
		em.persist(customerOrderEntity);
	}

	@Override
	public void create(String name, String manufacturer, int quantity) {
		CustomerOrderEntity b = new CustomerOrderEntity( name, manufacturer,   quantity);
		em.persist(b);
	}

	@Override
	public List<CustomerOrder> getOrderList() {

		List<CustomerOrder> listCustomerOrder = em.createNamedQuery("queryOrders").getResultList();

		if (listCustomerOrder == null){
			logger.severe("My Test :- listCustomerOrder is null");
		}else {
			logger.severe("My Test :- listCustomerOrder is not null");

		}
		return listCustomerOrder;
	}
}