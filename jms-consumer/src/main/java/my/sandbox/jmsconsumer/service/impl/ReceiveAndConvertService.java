package my.sandbox.jmsconsumer.service.impl;

import my.sandbox.model.Order;
import my.sandbox.jmsconsumer.service.OrderReceiverService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service("receiveAndConvert")
public class ReceiveAndConvertService implements OrderReceiverService {
    private final JmsTemplate jms;

    public ReceiveAndConvertService(JmsTemplate jms) {
        this.jms = jms;
    }

    @Override
    public Order receiveOrder() {
        return (Order) jms.receiveAndConvert();
    }
}
