package my.sandbox.jmsproducer.web.rest;

import my.sandbox.model.Order;
import my.sandbox.jmsproducer.service.OrderMessageProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderResource {
    private final Map<String, OrderMessageProducer> producers;

    public OrderResource(Map<String, OrderMessageProducer> producers) {
        this.producers = producers;
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestParam(required = false, defaultValue = "default") String producer,
                                            @RequestBody Order order) {
        producers.get(producer).sendOrder(order);

        return ResponseEntity.ok().build();
    }
}