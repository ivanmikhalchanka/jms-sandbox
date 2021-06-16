package my.sandbox.jmsconsumer.service.impl;

import lombok.SneakyThrows;
import my.sandbox.jmsconsumer.model.Order;
import my.sandbox.jmsconsumer.service.OrderReceiverService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Service;

import javax.jms.Message;

@Service("default")
public class ConvertFromMessageService implements OrderReceiverService {
    private final JmsTemplate jms;
    private final MessageConverter converter;

    public ConvertFromMessageService(JmsTemplate jms, MessageConverter converter) {
        this.jms = jms;
        this.converter = converter;
    }

    @SneakyThrows
    @Override
    public Order receiveOrder() {
        Message message = jms.receive();

        return (Order) converter.fromMessage(message);
    }
}
