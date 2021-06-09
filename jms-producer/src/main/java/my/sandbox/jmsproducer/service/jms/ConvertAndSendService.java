package my.sandbox.jmsproducer.service.jms;

import my.sandbox.jmsproducer.model.Order;
import my.sandbox.jmsproducer.service.OrderMessagingService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("convertAndSend")
public class ConvertAndSendService implements OrderMessagingService {
    private final JmsTemplate jms;

    public ConvertAndSendService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void sendOrder(Order order) {
        jms.convertAndSend(order);
    }
}