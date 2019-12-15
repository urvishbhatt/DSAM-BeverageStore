package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.model.Beverage;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import java.util.logging.Logger;

@Stateless
public class BeverageSender {
    private static final Logger logger = Logger.getLogger(QueueSender.class.getName());

    @Resource(mappedName = "TestCFAssignment")
    private ConnectionFactory factory;

    @Resource(mappedName = "testQueueAssignment")
    private Queue target;

    public void sendMessage(Beverage beverage) {
        try (Connection connection = factory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(target);
            ObjectMessage message = session.createObjectMessage(beverage);
            producer.send(message);
        } catch (JMSException ex) {
            logger.severe("Could not send message to Queue" + ex);
        }
    }
}
