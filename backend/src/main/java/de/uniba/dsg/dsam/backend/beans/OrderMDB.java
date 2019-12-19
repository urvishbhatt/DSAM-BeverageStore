package de.uniba.dsg.dsam.backend.beans;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import de.uniba.dsg.dsam.backend.entities.CustomerOrderEntity;
import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.model.CustomerOrder;
import de.uniba.dsg.dsam.persistence.BeverageManagement;
import de.uniba.dsg.dsam.persistence.OrderManagement;

/**
 * Message-Driven Bean implementation class for: NewRoomMDB
 *
 */
// COMMENT
// The queue name could be configured within this annotation using the "mappedName" attribute, i.e., mappedName = "testQueue".
// From a configuration point of view the use of the according deployment descriptor is more sensible.
@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class OrderMDB implements MessageListener {
    private static final Logger logger = Logger.getLogger(OrderMDB.class.getName());
    // COMMENT
    // Use container's dependency injection for the functionality you need.
    @EJB
    OrderManagement orderManagementObject;

    /**
     * Default constructor.
     */
    public OrderMDB() {

    }

    /**
     * @see MessageListener#onMessage(Message)
     */
    public void onMessage(Message message) {

        if (message == null) {
            logger.warning("Received null message via room insertion queue");
            return;
        }

        if (message instanceof ObjectMessage) {
            try {
                Object o = ((ObjectMessage) message).getObject();
                if (validate(o)) {
                    orderManagementObject.create((CustomerOrder) o);
                }

            } catch (JMSException e) {
                logger.severe("Error in accessing object" + e);
            }
        } else {
            logger.warning("Received message of unexpected JMS message type " + message);
        }
    }


    private boolean validate(Object o) {
        if (o == null || !(o instanceof CustomerOrder)) {
            logger.warning("Unexpected object for RawRoomDTO validation " + o);
            return false;
        }
        CustomerOrder rrd = (CustomerOrder) o;
        if (rrd.getName() != null && rrd.getQuantity() > 0)
            return true;
        else {
            logger.warning("Invalid RawRoomDTO attributes " + rrd);
            return false;
        }
    }

}