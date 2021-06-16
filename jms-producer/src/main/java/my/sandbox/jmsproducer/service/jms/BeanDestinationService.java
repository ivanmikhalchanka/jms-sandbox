package my.sandbox.jmsproducer.service.jms;

import my.sandbox.model.Order;
import my.sandbox.jmsproducer.service.OrderMessageProducer;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;

@Service("beanDestination")
public class BeanDestinationService implements OrderMessageProducer {
    private final JmsTemplate jms;
    private final Destination customDestination;

    public BeanDestinationService(JmsTemplate jms, Destination customDestination) {
        this.jms = jms;
        this.customDestination = customDestination;
    }

    @Override
    public void sendOrder(Order order) {
        jms.send(customDestination, session -> session.createObjectMessage(order));
    }
}
