package my.sandbox.jmsproducer.service.jms;

import my.sandbox.jmsproducer.service.OrderMessageProducer;
import my.sandbox.model.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("default")
public class DefaultDestinationService implements OrderMessageProducer {
    private final JmsTemplate jms;

    public DefaultDestinationService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void sendOrder(Order order) {
        jms.send(session -> session.createObjectMessage(order));
    }
}
