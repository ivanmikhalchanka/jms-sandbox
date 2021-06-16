package my.sandbox.jmsconsumer.service.impl;

import my.sandbox.model.Order;
import my.sandbox.jmsconsumer.service.OrderReceiverService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("stringDestination")
public class StringDestinationService implements OrderReceiverService {
    private final JmsTemplate jms;
    private final String destination;

    public StringDestinationService(JmsTemplate jms, @Value("${app.jms.custom-destination}") String destination) {
        this.jms = jms;
        this.destination = destination;
    }

    @Override
    public Order receiveOrder() {
        return (Order) jms.receiveAndConvert(destination);
    }
}
