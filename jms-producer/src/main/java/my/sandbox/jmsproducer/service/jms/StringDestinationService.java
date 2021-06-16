package my.sandbox.jmsproducer.service.jms;

import my.sandbox.jmsproducer.model.Order;
import my.sandbox.jmsproducer.service.OrderMessageProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("stringDestination")
public class StringDestinationService implements OrderMessageProducer {
    private final JmsTemplate jms;
    private final String destination;

    public StringDestinationService(JmsTemplate jms,
                                    @Value("${app.jms.custom-destination}") String destination) {
        this.jms = jms;
        this.destination = destination;
    }

    @Override
    public void sendOrder(Order order) {
        jms.send(destination, session -> session.createObjectMessage(order));
    }
}
