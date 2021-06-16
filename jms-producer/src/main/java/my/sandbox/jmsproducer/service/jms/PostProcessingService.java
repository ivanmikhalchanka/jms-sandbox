package my.sandbox.jmsproducer.service.jms;

import my.sandbox.jmsproducer.service.OrderMessageProducer;
import my.sandbox.model.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;

@Service("postProcessing")
public class PostProcessingService implements OrderMessageProducer {
    public static final String ORDER_SOURCE_HEADER = "ORDER_SOURCE";
    private final JmsTemplate jms;

    public PostProcessingService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void sendOrder(Order order) {
        jms.convertAndSend(order, this::addOrderSource);
    }

    Message addOrderSource(Message message) throws JMSException {
        message.setStringProperty(ORDER_SOURCE_HEADER, "WEB");

        return message;
    }
}
