package my.sandbox.jmsproducer.service;

import my.sandbox.jmsproducer.model.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}