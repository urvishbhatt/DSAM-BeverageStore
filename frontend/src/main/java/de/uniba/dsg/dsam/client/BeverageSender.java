package de.uniba.dsg.dsam.client;

import de.uniba.dsg.dsam.model.Beverage;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;

@Stateless
public class BeverageSender {
    private static final Logger logger = Logger.getLogger(BeverageSender.class.getName());

    @Resource(mappedName = "TestCF")
    private ConnectionFactory factory;

    @Resource(mappedName = "testQueue")
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
