package de.uniba.dsg.dsam.client;
import de.uniba.dsg.dsam.model.CustomerOrder;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import java.util.logging.Logger;

@Stateless
public class OrderSender {
    private static final Logger logger = Logger.getLogger(OrderSender.class.getName());

    @Resource(mappedName = "BeverageStoreCF")
    private ConnectionFactory factory;

    @Resource(mappedName = "BeverageStoreQueue")
    private Queue target;

    public void sendMessage(CustomerOrder customerOrder) {
        try (Connection connection = factory.createConnection()) {
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(target);
            ObjectMessage message = session.createObjectMessage(customerOrder);
            producer.send(message);
        } catch (JMSException ex) {
            logger.severe("Could not send message to Queue" + ex);
        }
    }
}