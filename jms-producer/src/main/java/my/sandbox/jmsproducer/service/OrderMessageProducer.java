package my.sandbox.jmsproducer.service;

import my.sandbox.jmsproducer.model.Order;

public interface OrderMessageProducer {
    void sendOrder(Order order);
}