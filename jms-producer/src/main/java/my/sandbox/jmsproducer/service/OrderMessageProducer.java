package my.sandbox.jmsproducer.service;

import my.sandbox.model.Order;

public interface OrderMessageProducer {
    void sendOrder(Order order);
}