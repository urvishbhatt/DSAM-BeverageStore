package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.backend.entities.CustomerOrderEntity;
import de.uniba.dsg.dsam.model.CustomerOrder;
import de.uniba.dsg.dsam.persistence.OrderManagement;

import javax.ejb.Local;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
import java.util.logging.Logger;

@Stateful
@Local(OrderManagement.class)
public class OrderManagementDrivenBean implements OrderManagement {
	private static final Logger logger = Logger.getLogger(OrderManagement.class.getName());
	
	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	EntityManager em;
	
	@Override
	public void create(CustomerOrder orders) {
//		CustomerOrderEntity customerOrderEntity = new CustomerOrderEntity(orders.getName(),orders.getManufacturer(),orders.getQuantity(),orders.getIssueDate());
//		logger.severe("My Test create method");
//		em.persist(customerOrderEntity);

		CustomerOrderEntity order = new CustomerOrderEntity(orders.getName(),orders.getManufacturer(),orders.getQuantity(),orders.getIssueDate());
		logger.info("order details:-name"+order.getName()+"date"+order.getIssueDate()+"quantity"+order.getQuantity());
		System.out.println("name="+order.getName());
		em.persist(order);
		em.flush();
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