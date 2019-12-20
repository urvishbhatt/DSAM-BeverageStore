package de.uniba.dsg.dsam.backend.beans;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import de.uniba.dsg.dsam.model.CustomerOrder;
import de.uniba.dsg.dsam.persistence.OrderManagement;

@MessageDriven(
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge")
        },
        mappedName = "BeverageStoreQueue")

public class OrderMDB implements MessageListener {
    private static final Logger logger = Logger.getLogger(OrderMDB.class.getName());
    @EJB
    OrderManagement orderManagementObject;

    public OrderMDB() { }

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