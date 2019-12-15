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

/**
 * Message-Driven Bean implementation class for: NewRoomMDB
 *
 */
// COMMENT
// The queue name could be configured within this annotation using the "mappedName" attribute, i.e., mappedName = "testQueue".
// From a configuration point of view the use of the according deployment descriptor is more sensible.
@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class BeverageMDB implements MessageListener {
	private static final Logger logger = Logger.getLogger(BeverageMDB.class.getName());
	// COMMENT
	// Use container's dependency injection for the functionality you need.
	@EJB
	BeverageManagement bm;

	/**
	 * Default constructor.
	 */
	public BeverageMDB() {

	}

	/**
	 * @see MessageListener#onMessage(Message)
	 */
	public void onMessage(Message message) {
//		COMMENT
//    	Some test code for introducing exceptions.
//    	long val = System.currentTimeMillis();
//    	logger.info("System time is " + val);
//    	boolean err = val%2==0;
//    	logger.info("Err injection is " + err);
		if (message == null) {
			logger.warning("Received null message via room insertion queue");
			return;
		}

		if (message instanceof ObjectMessage) {
			try {
				Object o = ((ObjectMessage) message).getObject();
				if (validate(o)) {
//					COMMENT
//					This (the following 4 code lines) isn't a valid way for checking XA atomicity property.
//					RuntimeExceptions in "onMessage" force rollback,
//					but the method for persisting rooms hasn't even been called before. 
//					if(err){
//						logger.error("INTENTIONAL ERROR FOR XATESTING");
//						throw new RuntimeException("INTENTIONAL ERROR FOR XATESTING");
//					}
					bm.create((Beverage)o);
//					COMMENT
//					This (the following 4 code lines) is a more valid way as the exception is introduced
//					after having written the room insertion method.
//					if(err){
//						logger.error("INTENTIONAL ERROR FOR XATESTING");
//						throw new RuntimeException("INTENTIONAL ERROR FOR XATESTING");
//					}
				}

			} catch (JMSException e) {
				logger.severe("Error in accessing object" + e);
			}
		} else {
			logger.warning("Received message of unexpected JMS message type " + message);
		}
	}

	/**
	 * Checks incoming object for acceptance for processing according to RawRoomDTO
	 * rules
	 * 
	 * @param o the expected RawRoomDTO
	 * @return true in case the object can be processed as a RawRoomDTO
	 */
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
