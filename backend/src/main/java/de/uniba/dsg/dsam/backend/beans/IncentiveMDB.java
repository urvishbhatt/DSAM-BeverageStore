package de.uniba.dsg.dsam.backend.beans;

import de.uniba.dsg.dsam.model.Incentive;
import de.uniba.dsg.dsam.persistence.IncentiveManagement;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.util.logging.Logger;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class IncentiveMDB implements MessageListener {
    Logger logger = Logger.getLogger(IncentiveMDB.class.getName());

    @EJB
    IncentiveManagement incentiveManagement;

    @Override
    public void onMessage(Message message) {


        if (message == null) {
            logger.warning("Received null message via room insertion queue");
            return;
        }

        if (message instanceof ObjectMessage) {
            try {
                Object o = ((ObjectMessage) message).getObject();
                if (validate(o)) { incentiveManagement.create((Incentive)o); }
            } catch (JMSException e) {
                logger.severe("Error in accessing object" + e);
            }
        } else {
            logger.warning("Received message of unexpected JMS message type " + message);
        }
    }

    private boolean validate(Object o) {
        if (o == null || !(o instanceof Incentive)) {
            logger.warning("Unexpected object for RawRoomDTO validation " + o);
            return false;
        }
        Incentive rrd = (Incentive) o;
        if (rrd.getName() != null)
            return true;
        else {
            logger.warning("Invalid RawRoomDTO attributes " + rrd);
            return false;
        }
    }
}
