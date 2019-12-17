package de.uniba.dsg.dsam.backend.beans;

import java.util.logging.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import de.uniba.dsg.dsam.model.Beverage;
import de.uniba.dsg.dsam.persistence.BeverageManagement;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class BeverageMDB implements MessageListener {
	private static final Logger logger = Logger.getLogger(BeverageMDB.class.getName());

	@EJB
	BeverageManagement bm;

	/**
	 * Default constructor.
	 */
	public BeverageMDB() { }

	public void onMessage(Message message) {

		if (message == null) {
			logger.warning("Received null message via room insertion queue");
			return;
		}

		if (message instanceof ObjectMessage) {
			try {
				Object o = ((ObjectMessage) message).getObject();
				if (validate(o)) { bm.create((Beverage)o); }
			} catch (JMSException e) {
				logger.severe("Error in accessing object" + e);
			}
		} else {
			logger.warning("Received message of unexpected JMS message type " + message);
		}
	}

	private boolean validate(Object o) {
		if (o == null || !(o instanceof Beverage)) {
			logger.warning("Unexpected object for RawRoomDTO validation " + o);
			return false;
		}
		Beverage rrd = (Beverage) o;
		if (rrd.getName() != null && rrd.getQuantity() > 0)
			return true;
		else {
			logger.warning("Invalid RawRoomDTO attributes " + rrd);
			return false;
		}
	}

}
